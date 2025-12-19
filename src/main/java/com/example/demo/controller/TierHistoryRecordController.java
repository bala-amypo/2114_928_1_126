package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierHistoryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-history")
public class TierHistoryRecordController {

    private final TierHistoryRecordService service;

    public TierHistoryRecordController(TierHistoryRecordService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public TierHistoryRecord get(@PathVariable Long id) {
        return service.getHistoryById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<TierHistoryRecord> byCustomer(@PathVariable Long customerId) {
        return service.getHistoryByCustomer(customerId);
    }

    @GetMapping
    public List<TierHistoryRecord> getAll() {
        return service.getAllHistory();
    }
}
