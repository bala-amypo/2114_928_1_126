package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // GET /api/customers/lookup/{customerId}
    @GetMapping("/lookup/{customerId}")
    public CustomerProfile lookupByCustomerId(@PathVariable String customerId) {
        return customerProfileService.findByCustomerId(customerId);
    }
}
