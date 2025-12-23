package com.example.demo.service;

import com.example.demo.entity.TierUpgradeRule;

import java.util.List;

public interface TierUpgradeRuleService {
    TierUpgradeRule create(TierUpgradeRule rule);
    List<TierUpgradeRule> getAll();
}
