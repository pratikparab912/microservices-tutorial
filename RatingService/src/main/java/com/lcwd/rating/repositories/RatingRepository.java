package com.lcwd.rating.repositories;

import com.lcwd.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {
    //Custom Finder Methods
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
