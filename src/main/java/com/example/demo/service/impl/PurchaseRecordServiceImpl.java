package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository repository;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseRecord recordPurchase(PurchaseRecord purchaseRecord) {
        return repository.save(purchaseRecord);
    }

    @Override
    public PurchaseRecord getPurchaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase not found"));
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<PurchaseRecord> getAllPurchases() {
        return repository.findAll();
    }
}
