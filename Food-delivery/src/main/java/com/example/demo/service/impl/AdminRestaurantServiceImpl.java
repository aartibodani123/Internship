package com.example.demo.service.impl;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.model.Admin;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.AdminRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AdminRestaurantServiceImpl implements AdminRestaurantService {
    @Autowired
    RestaurantRepository repo;

    @Autowired
    AdminRepository adminrepo;

    public RestaurantResponseDTO addRestaurant(Restaurant restaurant, Long adminId) {
        Admin admin = adminrepo.findById(adminId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found"));
        restaurant.setAdmin(admin);
        Restaurant savedRestaurant = repo.save(restaurant);

        return new RestaurantResponseDTO(savedRestaurant);
    }
    public ResponseEntity<List<RestaurantResponseDTO>> getRestaurantTable(Pageable pageable) {

        Page<RestaurantResponseDTO> page = repo.findAll(pageable)
                .map(RestaurantResponseDTO::new);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
