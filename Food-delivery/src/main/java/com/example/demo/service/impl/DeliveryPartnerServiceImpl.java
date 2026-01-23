package com.example.demo.service.impl;

import com.example.demo.model.DeliveryPartner;
import com.example.demo.repository.DeliveryPartnerRepository;
import com.example.demo.service.DeliveryPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {
    @Autowired
    private DeliveryPartnerRepository repo;

    public void signUpDeliveryPartner(DeliveryPartner c){
        if (repo.existsByEmail(c.getEmail()))
            throw new RuntimeException("Email already registered");
        repo.save(c);
    }

    public String loginDeliveryPartner(DeliveryPartner c){
        if (!repo.existsByEmail(c.getEmail()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"DeliveryPartner Not Found");

        DeliveryPartner existingDeliveryPartner=repo.getDeliveryPartnerByEmail(c.getEmail());
        if(!Objects.equals(existingDeliveryPartner.getPassword(), c.getPassword()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Incorrect password");

        return "Login Successfull";

    }
    public List<DeliveryPartner> getDeliveryPartner(){
        return repo.findAll();
    }


    public DeliveryPartner getDeliveryPartnerById(Long id){
        return repo.findById(id).orElse(new DeliveryPartner());
    }

    public DeliveryPartner updateDeliveryPartner(DeliveryPartner c){
        DeliveryPartner existingDeliveryPartner = repo.findById(c.getId())
                .orElseThrow(() -> new RuntimeException("DeliveryPartner not found"));

        existingDeliveryPartner.setName(c.getName());
        existingDeliveryPartner.setEmail(c.getEmail());

        return repo.save(existingDeliveryPartner);
    }

    @Override
    public void deleteDeliveryPartnerById(Long id) {
        repo.deleteById(id);

    }

}
