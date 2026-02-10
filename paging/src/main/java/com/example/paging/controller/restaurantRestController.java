package com.example.paging.controller;

import com.example.paging.dto.PaginatedResponse;
import com.example.paging.dto.RestaurantResponseDTO;
import com.example.paging.model.Restaurant;
import com.example.paging.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class restaurantRestController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public PaginatedResponse<RestaurantResponseDTO> getRestaurants(Pageable pageable) {

        Page<RestaurantResponseDTO> page =
                restaurantService.getRestaurants(pageable);

        PaginatedResponse<RestaurantResponseDTO> response = new PaginatedResponse<>();
        response.setContent(page.getContent());
        response.setPage(page.getNumber());
        response.setSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return response;
}
}
