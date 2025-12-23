package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TierUpgradeEngineServiceImpl
        implements TierUpgradeEngineService {

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
                .orElseThrow();

        double totalSpend = purchaseRepo.findByCustomerId(customerId)
                .stream().mapToDouble(PurchaseRecord::getAmount).sum();

        int visits = visitRepo.findByCustomerId(customerId).size();

        ruleRepo.findAll().stream()
                .filter(r -> r.getFromTier()
                        .equals(customer.getCurrentTier()))
                .filter(r -> r.getMinSpend() <= totalSpend
                        && r.getMinVisits() <= visits
                        && r.getActive())
                .findFirst()
                .ifPresent(rule -> {
                    TierHistoryRecord history = new TierHistoryRecord();
                    history.setCustomerId(customerId);
                    history.setOldTier(customer.getCurrentTier());
                    history.setNewTier(rule.getToTier());
                    history.setReason("Auto upgrade");
                    customer.setCurrentTier(rule.getToTier());
                    customerRepo.save(customer);
                    historyRepo.save(history);
                });
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }
}
