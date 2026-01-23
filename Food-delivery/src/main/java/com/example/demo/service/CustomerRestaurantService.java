package com.example.demo.service;

import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.model.Restaurant;

import java.util.List;

public interface CustomerRestaurantService {
    List<RestaurantResponseDTO> getRestaurant();
}
