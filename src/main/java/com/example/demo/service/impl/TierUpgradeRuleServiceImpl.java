package com.example.demo.service.impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository ruleRepo;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule rule) {
        TierUpgradeRule existing = ruleRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        existing.setFromTier(rule.getFromTier());
        existing.setToTier(rule.getToTier());
        existing.setMinSpend(rule.getMinSpend());
        existing.setMinVisits(rule.getMinVisits());
        existing.setActive(rule.getActive());

        return ruleRepo.save(existing);
    }

    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return ruleRepo.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
