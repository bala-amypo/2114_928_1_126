package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository purchaseRepo;
    private final CustomerProfileRepository customerRepo;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository purchaseRepo,
                                     CustomerProfileRepository customerRepo) {
        this.purchaseRepo = purchaseRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public PurchaseRecord recordPurchase(Long customerId, PurchaseRecord purchase) {
        CustomerProfile customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        purchase.setCustomer(customer);
        return purchaseRepo.save(purchase);
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return purchaseRepo.findByCustomer_Id(customerId);
    }

    @Override
    public PurchaseRecord getPurchaseById(Long id) {
        return purchaseRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Purchase not found"));
    }

    @Override
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseRepo.findAll();
    }
}
