package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "tier_upgrade_rule",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fromTier", "toTier"})
    }
)
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromTier;

    @Column(nullable = false)
    private String toTier;

    private Double minSpend;

    private Integer minVisits;

    private Boolean active;

    @PrePersist
    public void validate() {
        if (minSpend != null && minSpend < 0) {
            throw new IllegalArgumentException("minSpend cannot be negative");
        }
        if (minVisits != null && minVisits < 0) {
            throw new IllegalArgumentException("minVisits cannot be negative");
        }
        if (active == null) {
            active = true;
        }
    }

    // getters and setters
}
