package com.example.paging.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantResponseDTO {

    private Long id;
    private String name;
    private String city;
    private String state;
    private String phone;
    private Double rating;
    private boolean active;
}
