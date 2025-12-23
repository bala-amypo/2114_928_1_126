package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.exception.ResourceNotFoundException;
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

    @Override
    public CustomerProfile create(CustomerProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<CustomerProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public CustomerProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }
}
