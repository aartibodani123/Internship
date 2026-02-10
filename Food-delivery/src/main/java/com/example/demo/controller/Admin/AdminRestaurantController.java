package com.example.demo.controller.Admin;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.model.Restaurant;
import com.example.demo.service.impl.AdminRestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/manage")
public class AdminRestaurantController {
    @Autowired
    AdminRestaurantServiceImpl service;

    @PostMapping("/{id}/addRestaurant")
    public ResponseEntity<ApiResponse<RestaurantResponseDTO>> addRestaurant(@RequestBody Restaurant r, @PathVariable Long id){
        RestaurantResponseDTO response=service.addRestaurant(r,id);
        ApiResponse<RestaurantResponseDTO> apiResponse=new ApiResponse<>(201,"Restaurant Added",response);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @GetMapping("/restaurant-table")
    public ResponseEntity<HttpStatus> getRestaurantTable(Pageable pageable) {
        return (ResponseEntity<HttpStatus>) ResponseEntity.ok();
    }


}
