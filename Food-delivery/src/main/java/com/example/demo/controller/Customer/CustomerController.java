package com.example.demo.controller.Customer;

import com.example.demo.model.Customer;
import com.example.demo.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    CustomerServiceImpl service;

    @PostMapping("/signup")
    public void signUpCustomer(@RequestBody Customer c){
        service.signUpCustomer(c);
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestBody Customer c){
        return service.loginCustomer(c);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @GetMapping("get/{id}")
    public Customer getCustomerById(@PathVariable Long  id){
        return service.getCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(@PathVariable Long id,@RequestBody Customer c){
        c.setUserId(id);
        service.updateCustomer(c,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Long  id){
        service.deleteCustomerById(id);
    }


}
