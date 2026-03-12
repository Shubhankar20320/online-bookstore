package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.book.entity.User;
import com.example.book.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3002")
public class AuthController {

    @Autowired
    private UserRepository repo;

    // signup
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    // login
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        User dbUser = repo.findByEmail(user.getEmail());

        if(dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return dbUser;
        }

        throw new RuntimeException("Invalid email or password");
    }
}