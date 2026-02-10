package com.example.paging.controller;

import com.example.paging.model.Restaurant;
import com.example.paging.repository.RestaurantRepo;
import com.example.paging.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class restaurantController {

    @GetMapping("/restaurants-page")
    public String restaurantsPage() {
        return "restaurants";
    }

}
