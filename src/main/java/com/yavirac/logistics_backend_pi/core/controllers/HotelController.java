package com.yavirac.logistics_backend_pi.core.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yavirac.logistics_backend_pi.core.entities.Hotel;
import com.yavirac.logistics_backend_pi.core.services.HotelService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/v1")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    // CREATE
    @PostMapping(value = "hotels")
    public Hotel save(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    // GET ALL
    @GetMapping(value = "hotels")
    public List<Hotel> getAll() {
        return hotelService.findAll();
    }

    // GET BY ID
    @GetMapping(value = "hotels/{id}")
    public Hotel getById(@PathVariable long id) {
        return hotelService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "hotels/{id}")
    public void deleteById(@PathVariable long id) {
        hotelService.deleteById(id);
    }

    // UPDATE
    @PutMapping(value = "hotels/{id}")
    public Hotel update(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    // PARTIAL UPDATE
    @PatchMapping(value = "hotels/{id}")
    public ResponseEntity<Hotel> updateById(@PathVariable long id, @RequestBody Hotel hotel) {
        return hotelService.updateById(id, hotel);
    }
}
