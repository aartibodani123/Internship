package com.example.demo.controller.Admin;

import com.example.demo.common.ApiResponse;
import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import org.springframework.ui.Model;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String viewCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        model.addAttribute("customerPage", customerPage);
        model.addAttribute("currentPage", page);

        return "admin/customer";  // JSP name
    }
}
