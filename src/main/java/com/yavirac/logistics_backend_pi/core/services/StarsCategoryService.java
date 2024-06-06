package com.yavirac.logistics_backend_pi.core.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.yavirac.logistics_backend_pi.core.entities.StarsCategory;
import com.yavirac.logistics_backend_pi.core.repositories.StarsCategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StarsCategoryService {

    private final StarsCategoryRepository starsCategoryRepository;

    // Create
    public StarsCategory save(StarsCategory starsCategory) {
        return starsCategoryRepository.save(starsCategory);
    }

    // Get All
    public List<StarsCategory> findAll() {
        return starsCategoryRepository.findAll();
    }

    // Get By Id
    public StarsCategory findById(Long id) {
        return starsCategoryRepository.findById(id).orElse(null);
    }

    // Delete
    public void deleteById(Long id) {
        starsCategoryRepository.deleteById(id);
    }

    // Partial Update
    public ResponseEntity<StarsCategory> updateById(long id, StarsCategory starsCategoryUpdate) {
        try {
            StarsCategory starsCategoryExist = findById(id);
            if (starsCategoryExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (starsCategoryUpdate.getName() != null)
                starsCategoryExist.setName(starsCategoryUpdate.getName());
            // Save Data
            StarsCategory starsCategorySave = save(starsCategoryExist);
            return ResponseEntity.ok(starsCategorySave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };
}
