package com.driagon.ecommerce.services.app.controllers;

import com.driagon.ecommerce.services.app.dto.User;
import com.driagon.ecommerce.services.app.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return this.service.fetchAllUsers();
    }

    @GetMapping("/api/users/{id}")
    public User getAllUserById(@PathVariable Long id) {
        return this.service.fetchUser(id);
    }

    @PostMapping("/api/users")
    public String createUser(@RequestBody User user) {
        this.service.addUser(user);
         return "User added successfully";
    }
}