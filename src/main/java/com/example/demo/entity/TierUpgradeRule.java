package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tier_upgrade_rule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromTier;

    @Column(nullable = false)
    private String toTier;

    @Column(nullable = false)
    private Integer minVisits;

    @Column(nullable = false)
    private Boolean active;
}
