package com.example.demo.service.impl;

//import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repo;
    public String signUpCustomer(Customer c){
        if (repo.existsByEmail(c.getEmail()))
                return "Un Successfull";
        repo.save(c);
        return "signup successfull";
    }
    public Customer loginCustomer(Customer c){
        if (!repo.existsByEmail(c.getEmail()))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found");
            return null;

        Customer existingCustomer=repo.getCustomerByEmail(c.getEmail());
        if(!Objects.equals(existingCustomer.getPassword(), c.getPassword()))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Incorrect password");
            return null;

        return existingCustomer;

    }
    public List<Customer> getCustomers(){
        return repo.findAll();
    }

    public Customer getCustomerById(long id){
        return repo.findById(id).orElse(new Customer());
    }

    public Customer updateCustomer(Customer c,Long id){
            Customer existingCustomer = repo.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not FOund"));

            existingCustomer.setName(c.getName());
            existingCustomer.setEmail(c.getEmail());

            return repo.save(existingCustomer);

    }

    public void deleteCustomerById(long id){
        repo.deleteById(id);
    }

}
