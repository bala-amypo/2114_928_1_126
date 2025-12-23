package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;

    public TierHistoryRecord() {
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setOldTier(String oldTier) {
        this.oldTier = oldTier;
    }

    public void setNewTier(String newTier) {
        this.newTier = newTier;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
