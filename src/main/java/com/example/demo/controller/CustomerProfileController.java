package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileRepository repository;

    public CustomerProfileController(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public CustomerProfile create(@RequestBody CustomerProfile profile) {
        return repository.save(profile);
    }

    @GetMapping
    public List<CustomerProfile> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public CustomerProfile getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
}
