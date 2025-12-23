package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.dto.CustomerProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    @Autowired
    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    // CREATE new customer
    @PostMapping
    public ResponseEntity<CustomerProfile> createCustomer(@RequestBody CustomerProfileRequest request) {
        CustomerProfile customer = new CustomerProfile();
        if (request.getCustomerId() != null) {
            customer.setCustomerId(Long.valueOf(request.getCustomerId())); // convert String -> Long
        }
        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setUsername(request.getUsername());
        customer.setPassword(request.getPassword());
        customer.setActive(request.isActive());
        customer.setCurrentTier(request.getCurrentTier());

        CustomerProfile saved = customerProfileService.saveCustomer(customer);
        return ResponseEntity.ok(saved);
    }

    // READ all customers
    @GetMapping
    public ResponseEntity<List<CustomerProfile>> getAllCustomers() {
        List<CustomerProfile> customers = customerProfileService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    // READ customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getCustomerById(@PathVariable Long id) {
        CustomerProfile customer = customerProfileService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    // UPDATE customer
    @PutMapping("/{id}")
    public ResponseEntity<CustomerProfile> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerProfileRequest request) {
        CustomerProfile customer = customerProfileService.getCustomerById(id);
        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setUsername(request.getUsername());
        customer.setPassword(request.getPassword());
        customer.setActive(request.isActive());
        customer.setCurrentTier(request.getCurrentTier());

        CustomerProfile updated = customerProfileService.saveCustomer(customer);
        return ResponseEntity.ok(updated);
    }

    // DELETE customer
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerProfileService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
