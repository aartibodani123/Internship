package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.DeliveryPartner;
import com.example.demo.service.DeliveryPartnerServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery-partner")
public class DeliveryPartnerController {
    @Autowired
    private DeliveryPartnerServiceimp service;
    @PostMapping("/create")
    public DeliveryPartner addDeliveryPartner(@RequestBody DeliveryPartner d){
        return service.addDeliveryPartner(d);

    }
    @GetMapping
    public List<DeliveryPartner> getDeliveryPartner(){
        return service.getDeliveryPartner();
    }

    @GetMapping("/{id}")
    public DeliveryPartner getDeliveryPartnerById(@PathVariable Long  id){
        return service.getDeliveryPartnerById(id);
    }

    @PutMapping("/{id}")
    public DeliveryPartner updateDeliveryPartner(@PathVariable Long id,@RequestBody DeliveryPartner c){
        c.setUserId(id);
        return service.updateDeliveryPartner(c);
    }

    @DeleteMapping("/{id}")
    public void deleteDeliveryPartnerById(@PathVariable Long  id){
        service.deleteDeliveryPartnerById(id);
    }
}
