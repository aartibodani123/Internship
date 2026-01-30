package com.example.relationmapping.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Companies")
@Data
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Company_id;

    private String Company_name;

    @JsonManagedReference
    @OneToMany(mappedBy = "company" , cascade = CascadeType.ALL)
    private List<Customer> customers=new ArrayList<>();


}
