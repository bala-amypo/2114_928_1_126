package com.example.demo.service;

import com.example.demo.model.CustomerProfile;

import java.util.List;


public interface TierUpgradeEngineService {

    // Get all customers
    List<CustomerProfile> getAllCustomers();

    // Get customer by ID
    CustomerProfile getCustomerById(Long id);

    // Create customer
    CustomerProfile createCustomer(CustomerProfile customerProfile);

    // Update customer
    CustomerProfile updateCustomer(Long id, CustomerProfile customerProfile);

    // Delete customer
    void deleteCustomer(Long id);

    // Apply tier upgrade logic
    CustomerProfile applyTierUpgrade(Long customerId);
}
