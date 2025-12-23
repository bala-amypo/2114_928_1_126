package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tier_upgrade_rule")
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;
    private Integer minVisits;
    private Boolean active;

    // ===== Constructors =====
    public TierUpgradeRule() {
    }

    public TierUpgradeRule(Long id, String fromTier, String toTier, Integer minVisits, Boolean active) {
        this.id = id;
        this.fromTier = fromTier;
        this.toTier = toTier;
        this.minVisits = minVisits;
        this.active = active;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getFromTier() {
        return fromTier;
    }

    public String getToTier() {
        return toTier;
    }

    public Integer getMinVisits() {
        return minVisits;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFromTier(String fromTier) {
        this.fromTier = fromTier;
    }

    public void setToTier(String toTier) {
        this.toTier = toTier;
    }

    public void setMinVisits(Integer minVisits) {
        this.minVisits = minVisits;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
