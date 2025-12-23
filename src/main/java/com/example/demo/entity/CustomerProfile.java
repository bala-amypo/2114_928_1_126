package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String currentTier;
    private boolean active;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<PurchaseRecord> purchases;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<VisitRecord> visits;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<TierHistoryRecord> tierHistory;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCurrentTier() { return currentTier; }
    public void setCurrentTier(String currentTier) { this.currentTier = currentTier; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
