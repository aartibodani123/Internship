package com.example.demo.service;

import com.example.demo.model.DeliveryPartner;

import java.util.List;


public interface DeliveryPartnerService {
    public DeliveryPartner addDeliveryPartner(DeliveryPartner d);

    List<DeliveryPartner> getDeliveryPartner();

    DeliveryPartner getDeliveryPartnerById(Long id);

    DeliveryPartner updateDeliveryPartner(DeliveryPartner c);

    void deleteDeliveryPartnerById(Long id);
}
