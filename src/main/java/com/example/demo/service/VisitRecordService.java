package com.example.demo.service;

import com.example.demo.entity.VisitRecord;

import java.util.List;

public interface VisitRecordService {
    VisitRecord create(VisitRecord record);
    List<VisitRecord> getByCustomer(Long customerId);
}
