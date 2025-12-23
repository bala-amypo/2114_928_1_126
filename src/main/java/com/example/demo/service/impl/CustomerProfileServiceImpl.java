package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    public CustomerProfile create(CustomerProfile customer) {
        return repository.save(customer);
    }

    public CustomerProfile getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<CustomerProfile> getAll() {
        return repository.findAll();
    }

    public CustomerProfile update(Long id, CustomerProfile customer) {
        customer.setId(id);
        return repository.save(customer);
    }
}
