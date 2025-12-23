package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Double amount;

    private LocalDate purchaseDate;

    private String storeLocation;

    @PrePersist
    public void validate() {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Purchase amount must be > 0");
        }
        if (purchaseDate == null) {
            purchaseDate = LocalDate.now();
        }
    }

    // getters and setters
}
