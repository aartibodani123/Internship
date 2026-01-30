package com.example.relationmapping.controller;

import com.example.relationmapping.model.Customer;
import com.example.relationmapping.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerService service;

    public CustomerController(CustomerService service){
        this.service=service;
    }

    @PostMapping("/create")
    public void addCustomer(@RequestBody Customer c){
        service.addCustomer(c);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Long id){
        service.deleteCustomerById(id);
    }
    @GetMapping("/get")
    public List<Customer> getCustomerDetails(){
        return service.getCustomerDetails();
    }
}
