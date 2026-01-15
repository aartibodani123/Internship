package com.example.simplewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Product {
    private int prodId;
    private String prodName;
    private int price;

    public int getProdId() {
        return prodId;
    }
}
