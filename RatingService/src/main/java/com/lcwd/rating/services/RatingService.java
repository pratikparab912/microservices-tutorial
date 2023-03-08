package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating create(Rating rating);

    //Get All Ratings
    List<Rating> getRatings();

    //Get All By userId
    List<Rating> getRatingByUserId(String userId);

    //Get All By Hotel
    List<Rating> getRatingByHotelId(String hotelId);
}
