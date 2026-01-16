package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.DeliveryPartner;
import com.example.demo.model.Role;
import com.example.demo.repository.DeliveryPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPartnerServiceimp implements DeliveryPartnerService {
    @Autowired
    private DeliveryPartnerRepository repo;

    public DeliveryPartner addDeliveryPartner(DeliveryPartner d){
        d.setRole(Role.DELIVERY_PARTNER);
        return repo.save(d);
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

    }

    public void deleteDeliveryPartnerById(long id){
        repo.deleteById(id);
    }
}
