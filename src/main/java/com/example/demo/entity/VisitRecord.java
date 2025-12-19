package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visit_record")
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long customerId;

    private LocalDate visitDate;

    @Column(nullable = false)
    private String channel;

    @PrePersist
    public void validate() {
        if (!("STORE".equals(channel) || "APP".equals(channel) || "WEB".equals(channel))) {
            throw new IllegalArgumentException("Invalid visit channel");
        }
        if (visitDate == null) {
            visitDate = LocalDate.now();
        }
    }

    // getters and setters
}
