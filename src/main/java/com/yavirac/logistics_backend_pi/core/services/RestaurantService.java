package com.yavirac.logistics_backend_pi.core.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.yavirac.logistics_backend_pi.core.entities.Restaurant;
import com.yavirac.logistics_backend_pi.core.repositories.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    // Create
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Get All
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    // Get By Id
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    // Delete
    public void deleteById(Long id) {
        restaurantRepository.deleteById(id);
    }

    // Partial Update
    public ResponseEntity<Restaurant> updateById(Long id, Restaurant restaurantUpdate) {
        try {
            Restaurant restaurantExist = findById(id);
            if (restaurantExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (restaurantUpdate.getName() != null)
                restaurantExist.setName(restaurantUpdate.getName());
            if (restaurantUpdate.getAddress() != null)
                restaurantExist.setAddress(restaurantUpdate.getAddress());
            if (restaurantUpdate.getEnable() != null)
                restaurantExist.setEnable(restaurantUpdate.getEnable());
            // Save Data
            Restaurant restaurantSave = save(restaurantExist);
            return ResponseEntity.ok(restaurantSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };

}
