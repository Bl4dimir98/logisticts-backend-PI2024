package com.yavirac.logistics_backend_pi.core.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yavirac.logistics_backend_pi.core.entities.Restaurant;
import com.yavirac.logistics_backend_pi.core.services.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    // CREATE
    @PostMapping(value = "restaurants")
    public Restaurant save(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    // GET ALL
    @GetMapping(value = "restaurants")
    public List<Restaurant> getAll() {
        return restaurantService.findAll();
    }

    // GET BY ID
    @GetMapping(value = "restaurants/{id}")
    public Restaurant getById(@PathVariable Long id) {
        return restaurantService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "restaurants/{id}")
    public void deleteById(@PathVariable Long id) {
        restaurantService.deleteById(id);
    }

    // UPDATE
    @PutMapping(value = "restaurants/{id}")
    public Restaurant update(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    // PARTIAL UPDATE
    @PatchMapping(value = "restaurants/{id}")
    public ResponseEntity<Restaurant> updateById(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return restaurantService.updateById(id, restaurant);
    };
}
