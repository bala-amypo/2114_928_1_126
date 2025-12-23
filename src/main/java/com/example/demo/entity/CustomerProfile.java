package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String customerId;

    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String currentTier;
    private Boolean active;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<PurchaseRecord> purchases;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<VisitRecord> visits;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<TierHistoryRecord> history;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.currentTier == null) this.currentTier = "BRONZE";
        if (this.active == null) this.active = true;
    }

    // getters & setters
}
