package com.example.demo.service.impl;

import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    @Override
    public String evaluateTier(Long customerId) {
        return "Tier evaluation completed for customer " + customerId;
    }
}
