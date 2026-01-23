package com.example.demo.service.impl;

import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.model.Admin;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.AdminRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
}
