package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-upgrade")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService tierUpgradeEngineService;

    public TierUpgradeEngineController(TierUpgradeEngineService tierUpgradeEngineService) {
        this.tierUpgradeEngineService = tierUpgradeEngineService;
    }

    // ------------------ GET ALL CUSTOMERS ------------------
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerProfile>> getAllCustomers() {
        return ResponseEntity.ok(tierUpgradeEngineService.getAllCustomers());
    }

    // ------------------ GET CUSTOMER BY ID ------------------
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerProfile> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(tierUpgradeEngineService.getCustomerById(id));
    }

    // ------------------ CREATE CUSTOMER ------------------
    @PostMapping("/customer")
    public ResponseEntity<CustomerProfile> createCustomer(
            @RequestBody CustomerProfile customerProfile) {
        return ResponseEntity.ok(tierUpgradeEngineService.createCustomer(customerProfile));
    }

    // ------------------ UPDATE CUSTOMER ------------------
    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerProfile> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerProfile customerProfile) {
        return ResponseEntity.ok(
                tierUpgradeEngineService.updateCustomer(id, customerProfile)
        );
    }

    // ------------------ DELETE CUSTOMER ------------------
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        tierUpgradeEngineService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    // ------------------ APPLY TIER UPGRADE ------------------
    @PostMapping("/apply/{customerId}")
    public ResponseEntity<CustomerProfile> applyTierUpgrade(
            @PathVariable Long customerId) {
        return ResponseEntity.ok(
                tierUpgradeEngineService.applyTierUpgrade(customerId)
        );
    }
}
