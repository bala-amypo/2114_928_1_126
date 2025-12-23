package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
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

    // POST /evaluate/{customerId} - Run tier evaluation
    @PostMapping("/evaluate/{customerId}")
    public CustomerProfile evaluateTier(@PathVariable Long customerId) {
        return tierUpgradeEngineService.applyTierUpgrade(customerId);
    }

    // GET /history/{customerId} - Get history for a customer
    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistoryByCustomer(@PathVariable Long customerId) {
        return tierUpgradeEngineService.getHistory(customerId);
    }

    // GET /{id} - Get single history record by ID
    @GetMapping("/{id}")
    public TierHistoryRecord getHistoryById(@PathVariable Long id) {
        return tierUpgradeEngineService.getHistoryById(id);
    }

    // GET / - Get all history records
    @GetMapping
    public List<TierHistoryRecord> getAllHistory() {
        return tierUpgradeEngineService.getAllHistory();
    }
}
