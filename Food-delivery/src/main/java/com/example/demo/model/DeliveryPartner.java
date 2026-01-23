package com.example.demo.model;

import com.example.demo.model.enums.VehicleType;
import jakarta.persistence.*;

@Entity
@Table(name = "delivery_partners")
public class DeliveryPartner extends User {
    private Boolean available;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType vehicle_type;
    private Double rating;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public VehicleType getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(VehicleType vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setUserId(Long id) {

    }
}
