package com.dbmsproject.fellowtraveller.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "itinerary_id", nullable = false)
    private Itinerary itinerary;

    private String serviceType;

    private String serviceName;

    private LocalDate bookingDate;

    private BigDecimal cost;

    private String confirmationNumber;
}
