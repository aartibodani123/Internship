package com.example.demo.dto;

import com.example.demo.model.Restaurant;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RestaurantResponseDTO {

    private Long id;
    private String name;
    private String address;
    private String phone;
    public RestaurantResponseDTO(Restaurant r) {
        this.name = r.getName();
        this.address = r.getAddress();
        this.phone = r.getPhone();
    }


}

