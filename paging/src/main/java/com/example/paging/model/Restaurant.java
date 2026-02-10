package com.example.paging.model;

import jakarta.persistence.*;
import lombok.*;


@Table(name="restaurants")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;
    private String state;

    private String phone;
    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private boolean active=true;





}
