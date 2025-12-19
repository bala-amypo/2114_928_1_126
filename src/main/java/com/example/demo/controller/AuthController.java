package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        // Dummy auth (can replace later with Spring Security)
        if ("admin".equals(username) && "admin".equals(password)) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        return "User registered successfully";
    }
}
