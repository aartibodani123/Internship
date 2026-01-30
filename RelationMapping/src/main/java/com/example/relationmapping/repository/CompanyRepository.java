package com.example.relationmapping.repository;

import com.example.relationmapping.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
