package com.dbmsproject.fellowtraveller.repositories;

import com.dbmsproject.fellowtraveller.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dbmsproject.fellowtraveller.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {

    // Custom query to find all trips by user ID
//    @Query("SELECT t FROM trips t WHERE t.user.id = :userId")
//    List<Trip> getAllByUserId(@Param("userId") Long userId);

    @Query("SELECT t FROM Trip t WHERE t.user.id = :userId")
    List<Trip> findByUserId(Long userId);

//    // Custom query to find a trip by ID
//    @Query("SELECT t FROM Trip t WHERE t.id = :id")
//    Optional<Trip> getTripById(@Param("id") Long id);
//
//    // Custom query to create a new trip
//    @Modifying
//    @Query("INSERT INTO Trip (startLocation, destination, startDate, endDate, user) VALUES (:startLocation, :destination, :startDate, :endDate, :user)")
//    void createTrip(@Param("startLocation") String startLocation,
//                    @Param("destination") String destination,
//                    @Param("startDate") LocalDate startDate,
//                    @Param("endDate") LocalDate endDate,
//                    @Param("user") User user);
//
//    // Custom query to update an existing trip
//    @Modifying
//    @Query("UPDATE Trip t SET t.startLocation = :startLocation, t.destination = :destination, t.startDate = :startDate, t.endDate = :endDate WHERE t.id = :id")
//    void updateTrip(@Param("id") Long id,
//                    @Param("startLocation") String startLocation,
//                    @Param("destination") String destination,
//                    @Param("startDate") LocalDate startDate,
//                    @Param("endDate") LocalDate endDate);
}