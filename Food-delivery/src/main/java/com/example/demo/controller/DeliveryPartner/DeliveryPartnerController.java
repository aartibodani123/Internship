package com.example.demo.controller.DeliveryPartner;

import com.example.demo.model.DeliveryPartner;
import com.example.demo.service.impl.DeliveryPartnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery-partner")
public class DeliveryPartnerController {
    @Autowired
    private DeliveryPartnerServiceImpl service;

    @PostMapping("/signup")
    public void signUpDeliveryPartner(@RequestBody DeliveryPartner c){
        service.signUpDeliveryPartner(c);
    }

    @PostMapping("/login")
    public String loginDeliveryPartner(@RequestBody DeliveryPartner c){
        return service.loginDeliveryPartner(c);
    }

    @GetMapping
    public List<DeliveryPartner> getDeliveryPartner(){
        return service.getDeliveryPartner();
    }

    @GetMapping("getbyid/{id}")
    public DeliveryPartner getDeliveryPartnerById(@PathVariable Long  id){
        return service.getDeliveryPartnerById(id);
    }

    @PutMapping("update/{id}")
    public DeliveryPartner updateDeliveryPartner(@PathVariable Long id,@RequestBody DeliveryPartner c){
        c.setUserId(id);
        return service.updateDeliveryPartner(c);
    }

    @DeleteMapping("/{id}")
    public void deleteDeliveryPartnerById(@PathVariable Long  id){
        service.deleteDeliveryPartnerById(id);
    }
}
