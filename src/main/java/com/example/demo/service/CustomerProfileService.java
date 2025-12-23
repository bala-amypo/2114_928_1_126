package com.example.demo.service;

import com.example.demo.model.CustomerProfile;

import java.util.List;

public interface CustomerProfileService {
    CustomerProfile createCustomer(CustomerProfile customer);
    CustomerProfile getCustomerById(Long id);
    CustomerProfile findByCustomerId(String customerId); // Keep this
    List<CustomerProfile> getAllCustomers();
    void updateTier(Long id, String newTier);
    void updateStatus(Long id, boolean active);
}
