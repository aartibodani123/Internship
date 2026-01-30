package com.example.demo.controller.Customer;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.MenuItemResponseDTO;
import com.example.demo.model.MenuItem;
import com.example.demo.service.CustomerMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getmenu")
public class CustomerMenuItemController {
    @Autowired
    CustomerMenuItemService service;

    @GetMapping("/{Id}")
    public ResponseEntity<ApiResponse<List<MenuItemResponseDTO>>> getMenuItem(@PathVariable Long Id){
        List<MenuItemResponseDTO> items= service.getMenuItem(Id);
        ApiResponse<List<MenuItemResponseDTO>> apiResponse=new ApiResponse<>(200,"200 OK",items);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
