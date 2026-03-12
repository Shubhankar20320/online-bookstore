package com.example.book.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Book book;

    private int quantity;

    // Getters
    public Long getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Book getBook() {
        return book;
    }
    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}