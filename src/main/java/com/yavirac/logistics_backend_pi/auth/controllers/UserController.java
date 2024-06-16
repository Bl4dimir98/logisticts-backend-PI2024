package com.yavirac.logistics_backend_pi.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yavirac.logistics_backend_pi.auth.user.User;
import com.yavirac.logistics_backend_pi.auth.user.UserService;
import com.yavirac.logistics_backend_pi.core.entities.Tour;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    // Dependency injection
    private final UserService userService;

    // Get All
    @GetMapping(value = "users")
    public List<User> getAll() {
        return userService.findAll();
    };

    // Get By Id
    @GetMapping(value = "users/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    };

    // Update
    @PutMapping(value = "users/{id}")
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    // Partial Update
    @PatchMapping(value = "users/{id}")
    public ResponseEntity<User> updateById(@PathVariable long id, @RequestBody User user) {
        return userService.updateById(id, user);
    };

    // Assigns a user to a tour
    @PostMapping(value = "users/{uId}/tours/{tId}")
    public ResponseEntity<String> addUserToTour(@PathVariable Long uId, @PathVariable Long tId) {
        try {
            userService.addTourToUser(uId, tId);
            return ResponseEntity.ok("Tour asignado al usuario con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    };

    // Read tours by User
    @GetMapping(value = "{id}/tours")
    public List<Tour> getToursByUserId(@PathVariable Long id) {
        return userService.getToursByUser(id);
    };

}
