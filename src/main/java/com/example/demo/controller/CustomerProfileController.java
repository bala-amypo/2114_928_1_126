package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerProfile create(@RequestBody CustomerProfile c) {
        return service.createCustomer(c);
    }

    @GetMapping("/{id}")
    public CustomerProfile get(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping("/lookup/{customerId}")
    public CustomerProfile lookup(@PathVariable String customerId) {
        return service.findByCustomerId(customerId);
    }

    @GetMapping
    public List<CustomerProfile> getAll() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public CustomerProfile update(@PathVariable Long id, @RequestBody CustomerProfile c) {
        return service.updateCustomer(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}
