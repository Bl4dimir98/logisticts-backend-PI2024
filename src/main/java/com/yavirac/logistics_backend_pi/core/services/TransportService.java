package com.yavirac.logistics_backend_pi.core.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.yavirac.logistics_backend_pi.core.entities.Transport;
import com.yavirac.logistics_backend_pi.core.repositories.TransportRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportService {

    private final TransportRepository transportRepository;

    // Create
    public Transport save(Transport transport) {
        return transportRepository.save(transport);
    }

    // Get All
    public List<Transport> findAll() {
        return transportRepository.findAll();
    }

    // Get By ID
    public Transport findById(long id) {
        return transportRepository.findById(id).orElse(null);
    }

    // Delete 
    public void deleteById(long id) {
        transportRepository.deleteById(id);
    }

    // Partial Update
    public ResponseEntity<Transport> updateById(long id, Transport transportUpdate) {
        try {
            Transport transportExist = findById(id);
            if (transportExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (transportUpdate.getName() != null)
                transportExist.setName(transportUpdate.getName());
            if (transportUpdate.getPrice() != null)
                transportExist.setPrice(transportUpdate.getPrice());
            if (transportUpdate.getCapacity() != null)
                transportExist.setCapacity(transportUpdate.getCapacity());
            // if (transportUpdate.getEnable() != null)
                // transportExist.setEnable(transportUpdate.getEnable());
            // Save Data
            Transport transportSave = save(transportExist);
            return ResponseEntity.ok(transportSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };
}
