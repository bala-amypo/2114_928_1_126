package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService tierUpgradeRuleService;

    public TierUpgradeRuleController(TierUpgradeRuleService tierUpgradeRuleService) {
        this.tierUpgradeRuleService = tierUpgradeRuleService;
    }

    // POST /api/tier-rules
    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return tierUpgradeRuleService.createRule(rule);
    }

    // PUT /api/tier-rules/{id}
    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(@PathVariable Long id,
                                      @RequestBody TierUpgradeRule rule) {
        return tierUpgradeRuleService.updateRule(id, rule);
    }

    // GET /api/tier-rules/active
    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return tierUpgradeRuleService.getActiveRules();
    }

    // GET /api/tier-rules/lookup?fromTier=&toTier=
    @GetMapping("/lookup")
    public TierUpgradeRule lookupRule(@RequestParam String fromTier,
                                      @RequestParam String toTier) {
        return tierUpgradeRuleService.getRule(fromTier, toTier);
    }

    // GET /api/tier-rules
    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleService.getAllRules();
    }
}
