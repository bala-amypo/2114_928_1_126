package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerProfile customer;

    @PrePersist
    public void prePersist() {
        this.changedAt = LocalDateTime.now();
    }

    // getters & setters
}
