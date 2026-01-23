package com.example.demo.service;

import com.example.demo.model.DeliveryPartner;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface DeliveryPartnerService {
    public void signUpDeliveryPartner(DeliveryPartner c);
    public String loginDeliveryPartner(DeliveryPartner c);
    List<DeliveryPartner> getDeliveryPartner();

    DeliveryPartner getDeliveryPartnerById(Long id);

    DeliveryPartner updateDeliveryPartner(DeliveryPartner c);

    void deleteDeliveryPartnerById(Long id);
}
