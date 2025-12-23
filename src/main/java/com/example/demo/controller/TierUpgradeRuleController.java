package com.example.demo.controller;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public TierUpgradeRule create(@RequestBody TierUpgradeRule rule) {
        return service.createRule(rule);
    }

    // GET ALL
    @GetMapping
    public List<TierUpgradeRule> getAll() {
        return service.getAllRules();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TierUpgradeRule getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }
}
