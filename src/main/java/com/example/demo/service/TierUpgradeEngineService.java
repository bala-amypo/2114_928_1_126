package com.example.demo.service;

import com.example.demo.entity.TierHistoryRecord;
import java.util.List;

public interface TierUpgradeEngineService {

    String applyTierUpgrade(Long customerId);

    List<TierHistoryRecord> getHistory(Long customerId);

    TierHistoryRecord getHistoryById(Long id);

    List<TierHistoryRecord> getAllHistory();
}
