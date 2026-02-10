package com.example.demo.service;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminRestaurantService {
    RestaurantResponseDTO addRestaurant(Restaurant r, Long id);
    ResponseEntity<List<RestaurantResponseDTO>> getRestaurantTable(Pageable pageable);
}
