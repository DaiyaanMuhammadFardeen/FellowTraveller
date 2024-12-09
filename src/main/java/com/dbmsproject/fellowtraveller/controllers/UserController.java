package com.dbmsproject.fellowtraveller.controllers;

import com.dbmsproject.fellowtraveller.models.User;
import com.dbmsproject.fellowtraveller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.findByID(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try {
            User savedUser = userService.saveUser(user);
            URI uri = URI.create("/api/users/" + savedUser.getUserId());
            return ResponseEntity.created(uri).body(savedUser);
        }
        catch (SQLIntegrityConstraintViolationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        Optional<User> savedUser = userService.findByEmail(user.getEmail());
        if(savedUser.isPresent() && savedUser.get().getPasswordHash().equals(user.getPasswordHash())) {
            return ResponseEntity.ok(savedUser.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody User userDetails) throws SQLIntegrityConstraintViolationException {
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPasswordHash(userDetails.getPasswordHash());
            user.setPhone(userDetails.getPhone());
            userService.saveUser(user);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        if (userService.existsById(userId)) {
            userService.deleteById(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteUser(@PathVariable String name) {
        if (userService.existsByName(name)) {
            userService.deleteByName(name);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/preferences")
    public ResponseEntity<User> updatePreferences(@PathVariable Long id, @RequestBody String preferences) throws SQLIntegrityConstraintViolationException {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPreferences(preferences);
            User updatedUser = userService.saveUser(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
