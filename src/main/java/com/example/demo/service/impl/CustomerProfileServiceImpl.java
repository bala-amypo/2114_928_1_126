package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository customerRepo;

    public CustomerProfileServiceImpl(CustomerProfileRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        return customerRepo.save(customer);
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public void updateTier(Long id, String newTier) {
        CustomerProfile customer = getCustomerById(id);
        customer.setCurrentTier(newTier);
        customerRepo.save(customer);
    }

    @Override
    public void updateStatus(Long id, boolean active) {
        CustomerProfile customer = getCustomerById(id);
        customer.setActive(active);
        customerRepo.save(customer);
    }
}
