package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        if (request.getUsername() == null || request.getPassword() == null) {
            throw new IllegalArgumentException("Username and password required");
        }

        // In real implementation:
        // - save user
        // - encode password
        // - assign role

        return "User registered successfully with role: " + request.getRole();
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        if (request.getUsername() == null || request.getPassword() == null) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        // JWT generation logic assumed
        String dummyToken = "jwt-token-example";

        return new AuthResponse(dummyToken);
    }
}
