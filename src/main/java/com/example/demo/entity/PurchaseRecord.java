package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private LocalDate purchaseDate;
    private String storeLocation;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerProfile customer;

    @PrePersist
    public void validate() {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Purchase amount must be > 0");
        }
    }

    // getters & setters
}
