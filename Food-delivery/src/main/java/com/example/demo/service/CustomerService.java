package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> getCustomers();

    Customer getCustomerById(long id);

    void updateCustomer(Customer c,Long id);

    void deleteCustomerById(long id);

    void signUpCustomer(Customer c);

    String loginCustomer(Customer c);
}
