package com.example.relationmapping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="customer_profiles")
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String address;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name="customer_id")
    private Customer customer;

}