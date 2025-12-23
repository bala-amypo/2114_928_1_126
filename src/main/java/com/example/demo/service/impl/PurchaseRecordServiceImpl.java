package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseRecord;
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
    public PurchaseRecord create(PurchaseRecord record) {
        return repository.save(record);
    }

    @Override
    public List<PurchaseRecord> getByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }
}
