package com.example.simplewebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity
@Data
@AllArgsConstructor
public class Product {

    @Id
    private int prodId;

    private String prodName;
    private int price;

    public Product() {

    }

    public int getProdId() {
        return prodId;
    }

}
