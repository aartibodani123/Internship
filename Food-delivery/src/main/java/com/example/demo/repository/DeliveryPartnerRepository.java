package com.example.demo.repository;

import com.example.demo.model.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Long> {
    boolean existsByEmail(String email);


    DeliveryPartner getDeliveryPartnerByEmail(String email);
}
