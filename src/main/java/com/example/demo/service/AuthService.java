package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User register(RegisterRequest request) {

        userRepository.findByUsername(request.getUsername())
                .ifPresent(user -> {
                    throw new BadRequestException("Username already exists");
                });

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // plain for now (exam/demo)
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new BadRequestException("Invalid username or password"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadRequestException("Invalid username or password");
        }

        return "Login successful";
    }
}
