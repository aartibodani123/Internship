package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    CustomerServiceImp service;

    static class CustomerControllerService {

    }
    @PostMapping("/create")
    public Customer addCustomer(@RequestBody Customer c){
        return service.addCustomer(c);

    }

    @GetMapping
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long  id){
        return service.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,@RequestBody Customer c){
        c.setUserId(id);
        return service.updateCustomer(c);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long  id){
        service.deleteCustomerById(id);
    }


}
