package com.example.demo.controller;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService service;

    public PurchaseRecordController(PurchaseRecordService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseRecord create(@RequestBody PurchaseRecord p) {
        return service.recordPurchase(p);
    }

    @GetMapping("/{id}")
    public PurchaseRecord get(@PathVariable Long id) {
        return service.getPurchaseById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<PurchaseRecord> byCustomer(@PathVariable Long customerId) {
        return service.getPurchasesByCustomer(customerId);
    }

    @GetMapping
    public List<PurchaseRecord> getAll() {
        return service.getAllPurchases();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletePurchase(id);
    }
}
