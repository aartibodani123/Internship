package com.example.demo.service;

import com.example.demo.model.Admin;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminService {
    public String loginAdmin(Admin a);
}
