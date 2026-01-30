package com.example.relationmapping.service;

import com.example.relationmapping.model.Company;
import com.example.relationmapping.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    CompanyRepository repo;
    public CompanyService(CompanyRepository repo){
        this.repo=repo;
    }

    public void addCompany(Company company) {
        repo.save(company);
    }
}
