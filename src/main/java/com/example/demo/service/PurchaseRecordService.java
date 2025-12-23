package com.example.demo.service;

import com.example.demo.entity.PurchaseRecord;

import java.util.List;

public interface PurchaseRecordService {
    PurchaseRecord create(PurchaseRecord record);
    List<PurchaseRecord> getByCustomer(Long customerId);
}
