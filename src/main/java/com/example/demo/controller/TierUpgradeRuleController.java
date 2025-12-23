package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
@Tag(name = "Tier Upgrade Rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TierUpgradeRule create(@RequestBody TierUpgradeRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRule update(
            @PathVariable Long id,
            @RequestBody TierUpgradeRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/activ
