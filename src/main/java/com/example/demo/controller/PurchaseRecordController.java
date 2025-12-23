package com.example.demo.controller;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService purchaseRecordService;

    public PurchaseRecordController(PurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    // POST /api/purchases/customer/{customerId}
    @PostMapping("/customer/{customerId}")
    public PurchaseRecord recordPurchase(@PathVariable Long customerId,
                                         @RequestBody PurchaseRecord purchase) {
        return purchaseRecordService.recordPurchase(customerId, purchase);
    }

    // GET /api/purchases/customer/{customerId}
    @GetMapping("/customer/{customerId}")
    public List<PurchaseRecord> getPurchasesByCustomer(@PathVariable Long customerId) {
        return purchaseRecordService.getPurchasesByCustomer(customerId);
    }

    // GET /api/purchases/{id}
    @GetMapping("/{id}")
    public PurchaseRecord getPurchaseById(@PathVariable Long id) {
        return purchaseRecordService.getPurchaseById(id);
    }

    // GET /api/purchases
    @GetMapping
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseRecordService.getAllPurchases();
    }
}
