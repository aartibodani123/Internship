package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt-test")
public class JwtTestController {

    @GetMapping("/public")
    public String publicApi() {
        return "JWT PUBLIC API - no token needed";
    }

    @GetMapping("/private")
    public String privateApi() {
        return "JWT PRIVATE API - token is VALID ✅";
    }
}
