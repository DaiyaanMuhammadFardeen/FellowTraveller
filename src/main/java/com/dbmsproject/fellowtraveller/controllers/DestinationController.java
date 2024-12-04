package com.dbmsproject.fellowtraveller.controllers;

import com.dbmsproject.fellowtraveller.models.Destination;
import com.dbmsproject.fellowtraveller.models.Review;
import com.dbmsproject.fellowtraveller.services.DestinationService;
import com.dbmsproject.fellowtraveller.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    private final DestinationService destinationService;
    private final ReviewService reviewService;
    @Autowired
    public DestinationController(DestinationService destinationService, ReviewService reviewService) {
        this.destinationService = destinationService;
        this.reviewService = reviewService;
    }
    @GetMapping
    public List<Destination> getAllDestinations() { return destinationService.getAllDestinations(); }
    @GetMapping("/search")
    public List<Destination> searchDestinations(@RequestParam String query) {
        return destinationService.searchDestinations(query);
    }
    @GetMapping("{destinationId}")
    public Destination getDestinationById(@RequestParam Long destinationId) {
        return destinationService.getDestinationById(destinationId);
    }
    @GetMapping("/{destinationId}/reviews")
    public List<Review> getReviewsByDestinationId(@RequestParam Long destinationId) {
        return reviewService.getReviewsByDestinationId(destinationId);
    }
}
