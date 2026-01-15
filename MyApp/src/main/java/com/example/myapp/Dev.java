package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    @Autowired //field Injection
    @Qualifier("desktop")
    private Computer comp;
//    public Dev(Laptop laptop){   construction injection
//        this.laptop=laptop;
//    }
//    @Autowired       setter injection
//    public void setLaptop(Laptop laptop){
//        this.laptop=laptop;
//    }

    public void build(){
        comp.compile();
        System.out.println("Building the project");
    }
}
