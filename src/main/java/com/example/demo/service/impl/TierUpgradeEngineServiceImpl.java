package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.TierHistoryRecord;
import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierHistoryRecordRepository historyRepo;

    public TierUpgradeEngineServiceImpl(CustomerProfileRepository customerRepo,
                                        PurchaseRecordRepository purchaseRepo,
                                        VisitRecordRepository visitRepo,
                                        TierHistoryRecordRepository historyRepo) {
        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
        this.visitRepo = visitRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public CustomerProfile createCustomer(CustomerProfile customerProfile) {
        return customerRepo.save(customerProfile);
    }

    @Override
    public CustomerProfile updateCustomer(Long id, CustomerProfile customerProfile) {
        CustomerProfile existing = getCustomerById(id);
        existing.setCurrentTier(customerProfile.getCurrentTier());
        return customerRepo.save(existing);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public CustomerProfile applyTierUpgrade(Long customerId) {
        return getCustomerById(customerId); // logic later
    }

    @Override
    public List<TierHistoryRecord> getHistory(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }
}
