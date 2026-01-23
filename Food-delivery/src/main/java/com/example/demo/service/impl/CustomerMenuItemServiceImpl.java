package com.example.demo.service.impl;

import com.example.demo.dto.MenuItemResponseDTO;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.CustomerMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerMenuItemServiceImpl implements CustomerMenuItemService {
    @Autowired
    MenuItemRepository repo;

    @Autowired
    RestaurantRepository resrepo;

    public List<MenuItemResponseDTO> getMenuItem(Long restaurantId) {

        if (!resrepo.existsById(restaurantId)) {
            throw new RuntimeException("Restaurant not found");
        }

        return repo.findByRestaurantId(restaurantId)
                .stream()
                .map(mi -> {
                    MenuItemResponseDTO dto = new MenuItemResponseDTO();
                    dto.setId(mi.getId());
                    dto.setName(mi.getName());
                    dto.setDescription(mi.getDescription());
                    dto.setPrice(mi.getPrice());
                    dto.setAvailable(mi.isAvailable());
                    return dto;
                })
                .toList();
    }

}
