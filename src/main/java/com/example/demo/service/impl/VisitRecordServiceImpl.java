package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.VisitRecord;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository visitRepo;
    private final CustomerProfileRepository customerRepo;

    public VisitRecordServiceImpl(VisitRecordRepository visitRepo,
                                  CustomerProfileRepository customerRepo) {
        this.visitRepo = visitRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public VisitRecord recordVisit(Long customerId, VisitRecord visit) {
        CustomerProfile customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        visit.setCustomer(customer);
        return visitRepo.save(visit);
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return visitRepo.findByCustomer_Id(customerId);
    }

    @Override
    public VisitRecord getVisitById(Long id) {
        return visitRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Visit not found"));
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return visitRepo.findAll();
    }
}
