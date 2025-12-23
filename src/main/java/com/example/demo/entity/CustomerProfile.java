package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "customer_profiles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "customerId"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone")
    }
)
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerId;

    private String fullName;

    private String email;

    private String phone;

    private String currentTier;

    private Boolean active;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.currentTier == null) {
            this.currentTier = "BRONZE";
        }
        if (this.active == null) {
            this.active = true;
        }
    }

    // getters and setters
}
