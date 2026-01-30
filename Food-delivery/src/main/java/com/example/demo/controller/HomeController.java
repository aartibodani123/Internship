package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Show index.jsp when user visits root
    @GetMapping("/")
    public String home() {
        return "index"; // Spring will look for index.jsp
    }
}
