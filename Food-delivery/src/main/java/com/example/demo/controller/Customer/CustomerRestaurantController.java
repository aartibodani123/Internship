package com.example.demo.controller.Customer;

import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.service.CustomerRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class CustomerRestaurantController {
    @Autowired
    CustomerRestaurantService service;

    @GetMapping("/get")
    public List<RestaurantResponseDTO> getRestaurant(){
        return service.getRestaurant();
    }


}
