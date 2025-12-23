package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo;

    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerRepo,
            PurchaseRecordRepository purchaseRepo,
            VisitRecordRepository visitRepo,
            TierUpgradeRuleRepository ruleRepo,
            TierHistoryRecordRepository historyRepo) {

        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
        this.visitRepo = visitRepo;
        this.ruleRepo = ruleRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    public void evaluateAndUpgradeTier(Long customerId) {
        CustomerProfile customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        double totalSpend = purchaseRepo.findByCustomer_Id(customerId)
                .stream()
                .mapToDouble(PurchaseRecord::getAmount)
                .sum();

        int totalVisits = visitRepo.findByCustomer_Id(customerId).size();

        for (TierUpgradeRule rule : ruleRepo.findByActiveTrue()) {
            if (rule.getFromTier().equals(customer.getCurrentTier())
                    && totalSpend >= rule.getMinSpend()
                    && totalVisits >= rule.getMinVisits()) {

                String oldTier = customer.getCurrentTier();
                customer.setCurrentTier(rule.getToTier());
                customerRepo.save(customer);

                TierHistoryRecord history = new TierHistoryRecord();
                history.setCustomer(customer);
                history.setOldTier(oldTier);
                history.setNewTier(rule.getToTier());
                history.setReason("AUTO_UPGRADE");

                historyRepo.save(history);
            }
        }
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return historyRepo.findByCustomer_Id(customerId);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }
}
