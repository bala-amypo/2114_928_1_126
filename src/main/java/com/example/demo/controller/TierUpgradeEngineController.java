package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tier-upgrade")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService service;

    public TierUpgradeEngineController(TierUpgradeEngineService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerProfile upgrade(@RequestBody CustomerProfile customer) {
        return service.upgradeTier(customer);
    }
}
