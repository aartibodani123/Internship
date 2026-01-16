package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository repo;
    public Customer addCustomer(Customer c){
        c.setRole(Role.CUSTOMER);
        return repo.save(c);
    }

    public List<Customer> getCustomers(){
        return repo.findAll();
    }

    public Customer getCustomerById(long id){
        return repo.findById(id).orElse(new Customer());
    }

    public Customer updateCustomer(Customer c){
        Customer existingCustomer = repo.findById(c.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existingCustomer.setName(c.getName());
        existingCustomer.setEmail(c.getEmail());

        return repo.save(existingCustomer);
    }

    public void deleteCustomerById(long id){
        repo.deleteById(id);
    }
}
