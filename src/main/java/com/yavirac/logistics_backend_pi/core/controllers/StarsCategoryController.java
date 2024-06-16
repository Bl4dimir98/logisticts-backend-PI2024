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
import com.yavirac.logistics_backend_pi.core.entities.StarsCategory;
import com.yavirac.logistics_backend_pi.core.services.StarsCategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StarsCategoryController {

    private final StarsCategoryService starsCategoryService;

    // CREATE
    @PostMapping(value = "stars")
    public StarsCategory save(@RequestBody StarsCategory starsCategory) {
        return starsCategoryService.save(starsCategory);
    }

    // GET ALL
    @GetMapping(value = "stars")
    public List<StarsCategory> getAll() {
        return starsCategoryService.findAll();
    }

    // GET BY ID
    @GetMapping(value = "stars/{id}")
    public StarsCategory getById(@PathVariable long id) {
        return starsCategoryService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "stars/{id}")
    public void deleteById(@PathVariable long id) {
        starsCategoryService.deleteById(id);
    }

    // UPDATE
    @PutMapping(value = "star/{id}")
    public StarsCategory update(@RequestBody StarsCategory starsCategory) {
        return starsCategoryService.save(starsCategory);
    }

    // UPDATE PARTIAL
    @PatchMapping(value = "stars/{id}")
    public ResponseEntity<StarsCategory> updateById(@PathVariable long id, @RequestBody StarsCategory starsCategory) {
        return starsCategoryService.updateById(id, starsCategory);
    };
}
