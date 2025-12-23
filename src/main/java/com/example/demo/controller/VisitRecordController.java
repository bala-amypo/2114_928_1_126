package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService visitRecordService;

    public VisitRecordController(VisitRecordService visitRecordService) {
        this.visitRecordService = visitRecordService;
    }

    // POST /api/visits/customer/{customerId}
    @PostMapping("/customer/{customerId}")
    public VisitRecord recordVisit(@PathVariable Long customerId,
                                   @RequestBody VisitRecord visit) {
        return visitRecordService.recordVisit(customerId, visit);
    }

    // GET /api/visits/customer/{customerId}
    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable Long customerId) {
        return visitRecordService.getVisitsByCustomer(customerId);
    }

    // GET /api/visits/{id}
    @GetMapping("/{id}")
    public VisitRecord getVisitById(@PathVariable Long id) {
        return visitRecordService.getVisitById(id);
    }

    // GET /api/visits
    @GetMapping
    public List<VisitRecord> getAllVisits() {
        return visitRecordService.getAllVisits();
    }
}
