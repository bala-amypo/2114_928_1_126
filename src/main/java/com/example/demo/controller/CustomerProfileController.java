package com.example.demo.controller;

import com.example.demo.dto.CustomerProfileDTO;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Profile")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerProfile create(@RequestBody CustomerProfileDTO dto) {
        CustomerProfile customer = new CustomerProfile();
        customer.setCustomerId(dto.getCustomerId());
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        return service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfile getById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerProfile> getAll() {
        return service.getAllCustomers();
    }

    @GetMapping("/lookup/{customerId}")
    public CustomerProfile lookup(@PathVariable String customerId) {
        return service.findByCustomerId(customerId);
    }

    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(
            @PathVariable Long id,
            @RequestParam String tier) {
        return service.updateTier(id, tier);
    }

    @PutMapping("/{id}/status")
    public CustomerProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateStatus(id, active);
    }
}
