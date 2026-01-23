package com.example.demo.service;

import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.model.Restaurant;

public interface AdminRestaurantService {
    RestaurantResponseDTO addRestaurant(Restaurant r, Long id);
}
