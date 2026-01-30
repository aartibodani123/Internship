package com.example.relationmapping.controller;

import com.example.relationmapping.model.Company;
import com.example.relationmapping.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    CompanyService service;

    public CompanyController(CompanyService service){
        this.service=service;
    }

    @PostMapping("/add")
    public void addCompany(@RequestBody Company company){
        service.addCompany(company);

    }
}
