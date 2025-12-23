package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;

import java.util.List;

public interface PurchaseRecordService {

    PurchaseRecord recordPurchase(Long customerId, PurchaseRecord purchase);

    List<PurchaseRecord> getPurchasesByCustomer(Long customerId);

    PurchaseRecord getPurchaseById(Long id);

    List<PurchaseRecord> getAllPurchases();
}
