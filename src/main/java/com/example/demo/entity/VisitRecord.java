package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private LocalDate visitDate;

    private String channel;

    @PrePersist
    public void validate() {
        if (!channel.equals("STORE")
                && !channel.equals("APP")
                && !channel.equals("WEB")) {
            throw new IllegalArgumentException("Invalid visit channel");
        }
        if (visitDate == null) {
            visitDate = LocalDate.now();
        }
    }

    // getters and setters
}
