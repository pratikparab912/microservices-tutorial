package com.lcwd.hotel.controllers;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createHotel = hotelService.create(hotel);
        return new ResponseEntity<Hotel>(createHotel, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal) || hasAuthority('Admin')")
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id) {
        Hotel getById = hotelService.get(id);
        return new ResponseEntity<Hotel>(getById, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal)")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.ok(hotels);
    }
}
