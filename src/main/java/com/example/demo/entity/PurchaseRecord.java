package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "purchase_record")
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Double amount;

    private LocalDate purchaseDate;

    private String storeLocation;

    @PrePersist
    public void validate() {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Purchase amount must be greater than zero");
        }
        if (purchaseDate == null) {
            purchaseDate = LocalDate.now();
        }
    }

    // getters and setters
}
