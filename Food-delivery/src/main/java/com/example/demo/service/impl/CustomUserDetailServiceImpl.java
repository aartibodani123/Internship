package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.model.DeliveryPartner;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DeliveryPartnerRepository;
import com.example.demo.service.customUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomUserDetailServiceImpl implements customUserDetailService {

    private final CustomerRepository customerRepository;
    private final DeliveryPartnerRepository deliveryPartnerRepository;

    @Autowired
    public CustomUserDetailServiceImpl(CustomerRepository customerRepository,
                                       DeliveryPartnerRepository deliveryPartnerRepository) {
        this.customerRepository = customerRepository;
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        // Customer
        Optional<Customer> customerOpt = customerRepository.findByEmail(email);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();

            return org.springframework.security.core.userdetails.User
                    .withUsername(customer.getEmail())
                    .password(customer.getPassword())
                    .roles("CUSTOMER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
