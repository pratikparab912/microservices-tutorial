package com.lcwd.rating.controllers;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        Rating createRating = ratingService.create(rating);
        return new ResponseEntity<Rating>(createRating, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal)")
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        List<Rating> getAllRatings = ratingService.getRatings();
        return ResponseEntity.ok(getAllRatings);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal) || hasAuthority('Admin')")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
       List<Rating> getRatingByUserId = ratingService.getRatingByUserId(userId);
       return ResponseEntity.ok(getRatingByUserId);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal) || hasAuthority('Admin')")
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
       List<Rating> getRatingByHotelId = ratingService.getRatingByHotelId(hotelId);
       return ResponseEntity.ok(getRatingByHotelId);
    }
}
