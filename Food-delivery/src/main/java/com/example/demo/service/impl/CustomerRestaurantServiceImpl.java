package com.example.demo.service.impl;

import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.CustomerRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerRestaurantServiceImpl implements CustomerRestaurantService {

    @Autowired
    RestaurantRepository repo;

    public List<RestaurantResponseDTO> getRestaurant(){
        return repo.findAll()
                .stream()
                .map(RestaurantResponseDTO::new)
                .collect(Collectors.toList());
    }
}
