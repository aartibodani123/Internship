package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> getCustomers();

    Customer getCustomerById(long id);

    Customer updateCustomer(Customer c,Long id);

    void deleteCustomerById(long id);

    String signUpCustomer(Customer c);

    Customer loginCustomer(Customer c);
}
