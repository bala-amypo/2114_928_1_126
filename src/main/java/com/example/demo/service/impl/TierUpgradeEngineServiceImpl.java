package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.TierUpgradeRule;
import com.example.demo.model.VisitRecord;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeRuleService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;

    public TierUpgradeEngineServiceImpl(CustomerProfileRepository customerRepo,
                                        PurchaseRecordRepository purchaseRepo,
                                        VisitRecordRepository visitRepo,
                                        TierUpgradeRuleRepository ruleRepo) {
        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
        this.visitRepo = visitRepo;
        this.ruleRepo = ruleRepo;
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerRepo.findAll();
    }

    // ---------------- GET BY ID ----------------
    @Override
    public CustomerProfile getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // ---------------- CREATE ----------------
    @Override
    public CustomerProfile createCustomer(CustomerProfile customerProfile) {
        return customerRepo.save(customerProfile);
    }

    // ---------------- UPDATE ----------------
    @Override
    public CustomerProfile updateCustomer(Long id, CustomerProfile updated) {
        CustomerProfile existing = getCustomerById(id);

        existing.setFullName(updated.getFullName());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setActive(updated.getActive());
        existing.setCurrentTier(updated.getCurrentTier());

        return customerRepo.save(existing);
    }

    // ---------------- DELETE ----------------
    @Override
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

    // ---------------- APPLY TIER UPGRADE ----------------
    @Override
    public CustomerProfile applyTierUpgrade(Long customerId) {

        CustomerProfile customer = getCustomerById(customerId);

        // Total Spend
        double totalSpend = purchaseRepo.findByCustomerId(customerId)
                .stream()
                .mapToDouble(PurchaseRecord::getAmount)
                .sum();

        // Total Visits
        long totalVisits = visitRepo.findByCustomerId(customerId).size();

        // Find applicable rule
        List<TierUpgradeRule> rules = ruleRepo.findByActiveTrue();

        for (TierUpgradeRule rule : rules) {
            if (totalSpend >= rule.getMinSpend()
                    && totalVisits >= rule.getMinVisits()
                    && customer.getCurrentTier().equals(rule.getFromTier())) {

                customer.setCurrentTier(rule.getToTier());
                break;
            }
        }

        return customerRepo.save(customer);
    }
}
