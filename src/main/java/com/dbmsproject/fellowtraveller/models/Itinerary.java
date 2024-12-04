package com.dbmsproject.fellowtraveller.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Itineraries")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itineraryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal totalBudget;

    @Column(nullable = false, updatable = false)
    private LocalDate createdAt = LocalDate.now();
}
