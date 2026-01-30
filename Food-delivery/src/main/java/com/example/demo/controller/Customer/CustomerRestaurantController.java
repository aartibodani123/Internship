package com.example.demo.controller.Customer;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.service.CustomerRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class CustomerRestaurantController {
    @Autowired
    CustomerRestaurantService service;

    @GetMapping("/get")
//    public ResponseEntity<ApiResponse<List<RestaurantResponseDTO>>> getRestaurant(){
//
//        List<RestaurantResponseDTO> restaurants= service.getRestaurant();
//        ApiResponse<List<RestaurantResponseDTO>> apiResponse=new ApiResponse<>(200,"Reataurants details" ,restaurants);
//        return ResponseEntity.status(200).body(apiResponse);
//    }
    public String getRestaurant(Model model){
        List<RestaurantResponseDTO> restaurants=service.getRestaurant();
        model.addAttribute("restaurants" , restaurants);
        return "restaurants";
    }


}
