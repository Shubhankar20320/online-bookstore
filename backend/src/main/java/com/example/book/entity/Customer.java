package com.example.book.entity;

import jakarta.persistence.*;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String address;
    private String phone; // ✅ added phone field

    // Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;   // ✅ fixed
    }
    public void setEmail(String email) {
        this.email = email; // ✅ fixed
    }
    public void setAddress(String address) {
        this.address = address; // ✅ fixed
    }
    public void setPhone(String phone) {
        this.phone = phone; // ✅ added
    }
}