package com.example.demo.model;

import com.example.demo.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")   // 👈 IMPORTANT
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@Getter
@Setter
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_Id;
    private String user_name;
    private String phone;

    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    private String password;

    public User() {

    }


    // getters & setters
   public Long getId() {
       return user_Id;
   }

    public void setUserId(long userId) {
        this.user_Id = userId;
    }

   public String getName() {
      return user_name;
    }
//
    public void setName(String name) {
        this.user_name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
