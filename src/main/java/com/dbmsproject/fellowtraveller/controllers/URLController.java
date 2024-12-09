package com.dbmsproject.fellowtraveller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URLController {

    @GetMapping("/")
    public String index() {
        return "forward:/index.html";  // Assuming you want index.html for the root URL
    }

    @GetMapping("/login")
    public String login() {
        return "forward:/pages/login.html"; // Maps /login to /pages/login.html
    }

    @GetMapping("/settings")
    public String userSettings() {
        return "forward:/pages/usersettings.html"; // Maps /user-settings to /pages/usersettings.html
    }

    @GetMapping("/home")
    public String home() {
        return "forward:/pages/home.html"; // Maps /home to /pages/home.html
    }

    @GetMapping("/destination-maker")
    public String destinationMaker() {
        return "forward:/pages/destinationMaker.html"; // Maps /destination-maker to /pages/destinationMaker.html
    }
    @GetMapping("/destination/{destinationId}")
    public String destinationDetails() {
        return "forward:/pages/destinationPage.html"; // Maps /destination/{destinationId} to /pages/destination.html
    }
    @GetMapping("/booking/{destinationId}")
    public String bookingPage() {
        return "forward:/pages/booking.html"; // Maps /booking/{destinationId} to /pages/booking.html
    }
}
