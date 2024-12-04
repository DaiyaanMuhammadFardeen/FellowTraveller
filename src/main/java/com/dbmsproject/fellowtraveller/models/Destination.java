package com.dbmsproject.fellowtraveller.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destinationId;

    @Column(nullable = false, length = 200)
    private String name;

    private String description;

    @Column(nullable = false, length = 1024)
    private String location;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
