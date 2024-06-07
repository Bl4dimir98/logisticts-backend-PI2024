package com.yavirac.logistics_backend_pi.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yavirac.logistics_backend_pi.auth.user.User;
import com.yavirac.logistics_backend_pi.auth.user.UserService;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // GET ALL
    @GetMapping(value = "users")
    public List<User> getAll() {
        return userService.findAll();
    }

    // GET BY ID
    @GetMapping(value = "users/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }
    

}
