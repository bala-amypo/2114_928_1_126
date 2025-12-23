package com.example.demo.service.impl;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.AuthService;
import com.example.demo.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomerProfileRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(CustomerProfileRepository customerRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void register(RegisterRequest request) {
        if (customerRepository.existsByUsername(request.getUsername())) {
            throw new BadRequestException("Username is already taken");
        }

        CustomerProfile customer = new CustomerProfile();
        customer.setUsername(request.getUsername());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setEmail(request.getEmail());
        customer.setFullName(request.getFullName());
        customer.setActive(true);

        customerRepository.save(customer);
    }

    @Override
    public String login(LoginRequest request) {
        CustomerProfile customer = customerRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new BadRequestException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new BadRequestException("Invalid username or password");
        }

        return jwtUtil.generateToken(customer.getUsername());
    }
}
