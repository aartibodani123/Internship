package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class MenuItem {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    private boolean available=true;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;



}
