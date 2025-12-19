package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierHistoryRecord;
import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.TierUpgradeRule;
import com.example.demo.model.VisitRecord;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo; // ✅ Add history repo

    public TierUpgradeEngineServiceImpl(CustomerProfileRepository customerRepo,
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

    // --- Other methods omitted for brevity ---
    
    @Override
    public List<TierHistoryRecord> getHistory(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }
}
