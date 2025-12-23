package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class VisitRecord {

    private static final Set<String> VALID_CHANNELS =
            Set.of("STORE", "APP", "WEB");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate visitDate;
    private String channel;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerProfile customer;

    @PrePersist
    public void validate() {
        if (!VALID_CHANNELS.contains(channel)) {
            throw new IllegalArgumentException("Invalid visit channel");
        }
    }

    // getters & setters
}
