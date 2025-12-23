package com.example.demo.service.impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
@Service
public class TierUpgradeRuleServiceImpl
        implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repository.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule rule) {
        TierUpgradeRule existing = repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        existing.setMinSpend(rule.getMinSpend());
        existing.setMinVisits(rule.getMinVisits());
        existing.setActive(rule.getActive());
        return repository.save(existing);
    }

    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return repository.findAll()
                .stream()
                .filter(TierUpgradeRule::getActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }
}
