package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierHistoryRecord;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepository;
    private final TierHistoryRecordRepository historyRepository;

    public TierUpgradeEngineServiceImpl(CustomerProfileRepository customerRepository,
                                        TierHistoryRecordRepository historyRepository) {
        this.customerRepository = customerRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public CustomerProfile applyTierUpgrade(Long customerId) {

        CustomerProfile customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        String oldTier = customer.getCurrentTier();
        String newTier = "GOLD";

        if (!oldTier.equals(newTier)) {
            customer.setCurrentTier(newTier);

            TierHistoryRecord history = new TierHistoryRecord();
            history.setCustomerId(customerId);
            history.setOldTier(oldTier);
            history.setNewTier(newTier);
            history.setReason("Auto upgrade");

            historyRepository.save(history);
            customerRepository.save(customer);
        }

        return customer;
    }

    // ===== 3 GET OPERATIONS =====
    @Override
    public List<TierHistoryRecord> getHistory(Long customerId) {
        return historyRepository.findByCustomerId(customerId);
    }

    @Override
    public TierHistoryRecord getHistoryById(Long id) {
        return historyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("History not found"));
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepository.findAll();
    }
}
