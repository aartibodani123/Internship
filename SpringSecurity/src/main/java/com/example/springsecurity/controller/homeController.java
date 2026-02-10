package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @RequestMapping("/")
    public String getHome(){
        return "Hello World";
    }
}
