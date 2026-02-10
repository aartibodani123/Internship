package com.example.demo.controller.Admin;

import com.example.demo.common.ApiResponse;
import com.example.demo.model.Admin;
import com.example.demo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServiceImpl service;

//    @PostMapping("/login")
//    public ResponseEntity<ApiResponse<String>> loginAdmin(@RequestBody Admin a){
//        String savedresponce=service.loginAdmin(a);
//        ApiResponse<String> apiResponse=new ApiResponse<>(200,"Admin login successful",savedresponce);
//        return ResponseEntity.ok(apiResponse);
//
//    }
    @GetMapping("/login")
    public String adminLoginPage(){
        return "admin-login";
    }

    @GetMapping("/dashboard")
    public String adminDashboard(){
        return "admin-dashboard";
    }
}
