package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oldTier;
    private String newTier;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerProfile customer;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOldTier() { return oldTier; }
    public void setOldTier(String oldTier) { this.oldTier = oldTier; }

    public String getNewTier() { return newTier; }
    public void setNewTier(String newTier) { this.newTier = newTier; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
}
