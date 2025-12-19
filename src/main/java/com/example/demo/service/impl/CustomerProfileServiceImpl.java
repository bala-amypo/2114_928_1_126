package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    public CustomerProfile createCustomer(CustomerProfile customer) {
        return repository.save(customer);
    }

    public CustomerProfile getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public CustomerProfile findByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    public CustomerProfile updateCustomer(Long id, CustomerProfile updated) {
        CustomerProfile existing = getCustomerById(id);
        existing.setFullName(updated.getFullName());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setActive(updated.getActive());
        existing.setCurrentTier(updated.getCurrentTier());
        return repository.save(existing);
    }

    public void deleteCustomer(Long id) {
        repository.delete(getCustomerById(id));
    }
}
