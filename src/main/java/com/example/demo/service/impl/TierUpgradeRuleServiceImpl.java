package com.example.demo.service.impl;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {

        if (rule.getFromTier() == null || rule.getToTier() == null || rule.getMinVisits() == null) {
            throw new BadRequestException("Required fields are missing");
        }

        return repository.save(rule);
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public TierUpgradeRule getRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Rule not found with id: " + id));
    }
}
