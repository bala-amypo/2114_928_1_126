package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
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

    // ✅ POST — SAVE DATA
    @PostMapping
    public CustomerProfile create(@RequestBody CustomerProfile customer) {
        return service.create(customer);
    }

    // ✅ GET — FETCH DATA
    @GetMapping
    public List<CustomerProfile> getAll() {
        return service.getAll();
    }
}
