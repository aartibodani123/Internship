package com.example.demo.service;

import com.example.demo.dto.MenuItemResponseDTO;
import com.example.demo.model.MenuItem;

public interface AdminMenuItemService {
    MenuItemResponseDTO addMenuItem(MenuItem m, Long Id);
}
