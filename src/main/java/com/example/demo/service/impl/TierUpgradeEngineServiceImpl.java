package com.example.demo.service.impl;

import com.example.demo.entity.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    @Override
    public String applyTierUpgrade(Long customerId) {
        return "Tier upgraded for customer " + customerId;
    }

    @Override
    public List<TierHistoryRecord> getHistory(Long customerId) {
        return List.of();
    }

    @Override
    public TierHistoryRecord getHistoryById(Long id) {
        return null;
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return List.of();
    }
}
