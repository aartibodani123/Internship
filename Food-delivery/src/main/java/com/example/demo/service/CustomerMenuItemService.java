package com.example.demo.service;

import com.example.demo.dto.MenuItemResponseDTO;
import com.example.demo.model.MenuItem;

import java.util.List;

public interface CustomerMenuItemService {
    List<MenuItemResponseDTO> getMenuItem(Long id);
}
