package com.example.demo.repository;

import com.example.demo.model.TierHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TierHistoryRecordRepository extends JpaRepository<TierHistoryRecord, Long> {

    // Find all history records for a given customer
    List<TierHistoryRecord> findByCustomerId(Long customerId);
}
