package com.example.relationmapping.service;

import com.example.relationmapping.model.Customer;
import com.example.relationmapping.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository repo;
    public CustomerService(CustomerRepository repo){
        this.repo=repo;
    }
    public void addCustomer(Customer customer) {
        customer.getProfile().setCustomer(customer);
        repo.save(customer);
    }

    public void deleteCustomerById(Long id) {
        repo.deleteById(id);
    }

    public List<Customer> getCustomerDetails() {
        return repo.findAll();
    }
}
