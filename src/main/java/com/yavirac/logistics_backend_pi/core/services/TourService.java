package com.yavirac.logistics_backend_pi.core.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yavirac.logistics_backend_pi.core.entities.Tour;
import com.yavirac.logistics_backend_pi.core.repositories.TourRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;

    // Create
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }

    // Get All
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    // Get By ID
    public Tour findById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    // Delete
    public void deleteById(long id) {
        tourRepository.deleteById(id);
    }

    // Partial Update
    public ResponseEntity<Tour> updateById(long id, Tour tourUpdate) {
        try {
            Tour tourExist = findById(id);
            if (tourExist == null)
                return ResponseEntity.notFound().build();
            // Update each Field
            if (tourUpdate.getName() != null)
                tourExist.setName(tourUpdate.getName());
            if (tourUpdate.getDescription() != null)
                tourExist.setDescription(tourUpdate.getDescription());
            if (tourUpdate.getPrice() != null)
                tourExist.setPrice(tourUpdate.getPrice());
            if (tourUpdate.getDays_duration() != null)
                tourExist.setDays_duration(tourUpdate.getDays_duration());
            if (tourUpdate.getSector() != null)
                tourExist.setSector(tourUpdate.getSector());
            if (tourUpdate.getCapacity_quotes() != null)
                tourExist.setCapacity_quotes(tourUpdate.getCapacity_quotes());
            if (tourUpdate.getStart_date() != null)
                tourExist.setStart_date(tourUpdate.getStart_date());
            if (tourUpdate.getEnable() != null)
                tourExist.setEnable(tourUpdate.getEnable());
            // Save Data
            Tour tourSave = save(tourExist);
            return ResponseEntity.ok(tourSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };

}
