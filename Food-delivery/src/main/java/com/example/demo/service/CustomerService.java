package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer c);

    List<Customer> getCustomers();

    Customer getCustomerById(long id);

    Customer updateCustomer(Customer c);

    void deleteCustomerById(long id);
}
