package com.example.paging.service;

import com.example.paging.dto.RestaurantResponseDTO;
import com.example.paging.model.Restaurant;
import com.example.paging.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;
    public Page<RestaurantResponseDTO> getRestaurants(Pageable pageable) {
        return restaurantRepo.findAll(pageable)
                .map(r -> new RestaurantResponseDTO(
                        r.getId(),
                        r.getName(),
                        r.getCity(),
                        r.getState(),
                        r.getPhone(),
                        r.getRating(),
                        r.isActive()
                ));
    }
}
