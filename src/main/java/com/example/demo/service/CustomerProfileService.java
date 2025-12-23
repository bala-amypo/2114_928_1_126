package com.example.demo.service;

import com.example.demo.entity.CustomerProfile;
import java.util.List;

public interface CustomerProfileService {
    CustomerProfile create(CustomerProfile customer);
    List<CustomerProfile> getAll();
}
