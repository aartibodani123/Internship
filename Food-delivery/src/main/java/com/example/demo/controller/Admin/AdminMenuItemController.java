package com.example.demo.controller.Admin;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.MenuItemResponseDTO;
import com.example.demo.model.MenuItem;
import com.example.demo.service.impl.AdminMenuItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menuitem")
public class AdminMenuItemController {

    @Autowired
    AdminMenuItemServiceImpl service;

    @PostMapping("/{Id}/add")
    public ResponseEntity<ApiResponse<MenuItemResponseDTO>> addMenuItem(@RequestBody MenuItem m, @PathVariable Long Id){
        MenuItemResponseDTO item=service.addMenuItem(m,Id);
        ApiResponse<MenuItemResponseDTO> apiResponse=new ApiResponse<>(201,"Menu Item created",item);
        return ResponseEntity.status(201).body(apiResponse);
    }
}
