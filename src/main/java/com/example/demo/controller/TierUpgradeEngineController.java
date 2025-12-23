package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService tierUpgradeEngineService;

    public TierUpgradeEngineController(TierUpgradeEngineService tierUpgradeEngineService) {
        this.tierUpgradeEngineService = tierUpgradeEngineService;
    }

    // POST /api/tier-engine/evaluate/{customerId}
    @PostMapping("/evaluate/{customerId}")
    public void evaluateAndUpgrade(@PathVariable Long customerId) {
        tierUpgradeEngineService.evaluateAndUpgradeTier(customerId);
    }

    // GET /api/tier-engine/history/{customerId}
    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistoryByCustomer(@PathVariable Long customerId) {
        return tierUpgradeEngineService.getHistoryByCustomer(customerId);
    }

    // GET /api/tier-engine
    @GetMapping
    public List<TierHistoryRecord> getAllHistory() {
        return tierUpgradeEngineService.getAllHistory();
    }
}
