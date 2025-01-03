package com.dbmsproject.fellowtraveller.repositories;

import com.dbmsproject.fellowtraveller.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
}
