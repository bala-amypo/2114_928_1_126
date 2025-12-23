package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    @Override
    public CustomerProfile upgradeTier(CustomerProfile customer) {
        if ("silver".equalsIgnoreCase(customer.getCurrentTier())) {
            customer.setCurrentTier("gold");
        }
        return customer;
    }
}
