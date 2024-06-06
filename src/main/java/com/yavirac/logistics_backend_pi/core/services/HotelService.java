package com.yavirac.logistics_backend_pi.core.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.yavirac.logistics_backend_pi.core.entities.Hotel;
import com.yavirac.logistics_backend_pi.core.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    // Create
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Get All
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    // Get By Id
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    // Delete
    public void deleteById(long id) {
        hotelRepository.deleteById(id);
    }

    // Partial Update
    public ResponseEntity<Hotel> updateById(long id, Hotel hotelUpdate) {
        try {
            Hotel hotelExist = findById(id);
            if (hotelExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (hotelUpdate.getName() != null)
                hotelExist.setName(hotelUpdate.getName());
            if (hotelUpdate.getAddress() != null)
                hotelExist.setAddress(hotelUpdate.getAddress());
            if (hotelUpdate.getPhone() != null)
                hotelExist.setPhone(hotelExist.getPhone());
            if (hotelUpdate.getEmail() != null)
                hotelExist.setEmail(hotelUpdate.getEmail());
            if (hotelUpdate.getEnable() != null)
                hotelExist.setEnable(hotelUpdate.getEnable());
            // Save Data
            Hotel hotelSave = save(hotelExist);
            return ResponseEntity.ok(hotelSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };

}
