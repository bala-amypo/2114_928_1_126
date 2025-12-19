package com.example.demo.service.impl;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.service.TierHistoryRecordService;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class TierHistoryRecordServiceImpl implements TierHistoryRecordService {

    private final TierHistoryRecordRepository repository;

    public TierHistoryRecordServiceImpl(TierHistoryRecordRepository repository) {
        this.repository = repository;
    }

    public TierHistoryRecord saveHistory(TierHistoryRecord record) {
        return repository.save(record);
    }

    public TierHistoryRecord getHistoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("History record not found"));
    }

    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public List<TierHistoryRecord> getAllHistory() {
        return repository.findAll();
    }
}
