package com.example.demo.service.impl;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository repository;

    public VisitRecordServiceImpl(VisitRecordRepository repository) {
        this.repository = repository;
    }

    public VisitRecord recordVisit(VisitRecord visit) {
        if (!("STORE".equals(visit.getChannel())
                || "APP".equals(visit.getChannel())
                || "WEB".equals(visit.getChannel()))) {
            throw new IllegalArgumentException("Invalid visit channel");
        }
        return repository.save(visit);
    }

    public VisitRecord getVisitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Visit not found"));
    }

    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public List<VisitRecord> getAllVisits() {
        return repository.findAll();
    }

    public void deleteVisit(Long id) {
        repository.delete(getVisitById(id));
    }
}
