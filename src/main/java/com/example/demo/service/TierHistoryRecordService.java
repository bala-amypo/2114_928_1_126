package com.example.demo.service;

import com.example.demo.model.TierHistoryRecord;
import java.util.List;

public interface TierHistoryRecordService {
    TierHistoryRecord saveHistory(TierHistoryRecord record);
    TierHistoryRecord getHistoryById(Long id);
    List<TierHistoryRecord> getHistoryByCustomer(Long customerId);
    List<TierHistoryRecord> getAllHistory();
}
