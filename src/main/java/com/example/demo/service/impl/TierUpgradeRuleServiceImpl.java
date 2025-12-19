package com.example.demo.service.impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repository.save(rule);
    }

    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updated) {
        TierUpgradeRule existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        existing.setFromTier(updated.getFromTier());
        existing.setToTier(updated.getToTier());
        existing.setMinSpend(updated.getMinSpend());
        existing.setMinVisits(updated.getMinVisits());
        existing.setActive(updated.getActive());

        return repository.save(existing);
    }

    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    public List<TierUpgradeRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }

    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
