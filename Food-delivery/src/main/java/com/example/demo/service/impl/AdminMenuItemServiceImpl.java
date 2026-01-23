package com.example.demo.service.impl;

import com.example.demo.dto.MenuItemResponseDTO;
import com.example.demo.model.MenuItem;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.AdminMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminMenuItemServiceImpl implements AdminMenuItemService {
    @Autowired
    MenuItemRepository repo;

    @Autowired
    RestaurantRepository resrepo;
    public MenuItemResponseDTO addMenuItem(MenuItem m, Long Id){
        Restaurant res = resrepo.findById(Id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Resturant not found"));
        m.setRestaurant(res);
        MenuItem saved = repo.save(m);

        MenuItemResponseDTO dto = new MenuItemResponseDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setPrice(saved.getPrice());
        dto.setDescription(saved.getDescription());
        dto.setAvailable(saved.isAvailable());

        return dto;
    }
}
