package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="restaurants")
@Getter
@Setter
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String address;

    private String phone;

    @Column(nullable = false)
    private boolean active=true;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="admin_id",nullable = false)
    private Admin admin;

}
