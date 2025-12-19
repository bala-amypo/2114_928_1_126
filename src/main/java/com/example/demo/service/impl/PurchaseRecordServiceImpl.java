package com.example.demo.service.impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository repository;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository repository) {
        this.repository = repository;
    }

    public PurchaseRecord recordPurchase(PurchaseRecord p) {
        if (p.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }
        return repository.save(p);
    }

    public PurchaseRecord getPurchaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Purchase not found"));
    }

    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public List<PurchaseRecord> getAllPurchases() {
        return repository.findAll();
    }

    public void deletePurchase(Long id) {
        repository.delete(getPurchaseById(id));
    }
}
