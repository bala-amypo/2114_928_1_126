package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"fromTier", "toTier"}))
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;
    private Boolean active;

    @PrePersist
    @PreUpdate
    public void validate() {
        if (minSpend <= 0 || minVisits <= 0) {
            throw new IllegalArgumentException("Thresholds must be > 0");
        }
    }

    // getters & setters
}
