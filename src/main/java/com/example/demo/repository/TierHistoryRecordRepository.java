package com.example.demo.repository;

import com.example.demo.model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface TierHistoryRecordRepository extends JpaRepository<TierHistoryRecord, Long> {
    List<TierHistoryRecord> findByCustomer_Id(Long customerId);
}
