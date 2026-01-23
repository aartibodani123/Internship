package com.example.demo.service.impl;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;


@Service

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository repo;

    public String loginAdmin(Admin a){
        if(! repo.existsByEmail(a.getEmail())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Admin Not Found");
        }
        Admin existingAdmin=repo.getAdminByEmail(a.getEmail());
        if(! Objects.equals(existingAdmin.getPassword(),a.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Incorrect password");
        }
        return "Admin logged in";

    }
}
