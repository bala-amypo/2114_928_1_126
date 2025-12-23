package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    // POST /api/customers
    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerProfileService.createCustomer(customer);
    }

    // GET /api/customers/{id}
    @GetMapping("/{id}")
    public CustomerProfile getCustomer(@PathVariable Long id) {
        return customerProfileService.getCustomerById(id);
    }

    // GET /api/customers
    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileService.getAllCustomers();
    }

    // PUT /api/customers/{id}/tier
    @PutMapping("/{id}/tier")
    public void updateTier(@PathVariable Long id,
                           @RequestParam String newTier) {
        customerProfileService.updateTier(id, newTier);
    }

    // PUT /api/customers/{id}/status
    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id,
                             @RequestParam boolean active) {
        customerProfileService.updateStatus(id, active);
    }

    // Removed /lookup/{customerId} endpoint because customerId does not exist
}
