package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.AuthResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        // JWT generation logic assumed
        return new AuthResponse("dummy-jwt-token");
    }

    @PostMapping("/register")
    public String register(@RequestBody LoginRequest request) {
        return "User registered";
    }
}
