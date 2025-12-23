package com.example.demo.controller;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleController(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public TierUpgradeRule create(@RequestBody TierUpgradeRule rule) {
        return repository.save(rule);
    }

    @GetMapping
    public List<TierUpgradeRule> getAll() {
        return repository.findAll();
    }
}
