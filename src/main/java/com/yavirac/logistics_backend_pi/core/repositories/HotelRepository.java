package com.yavirac.logistics_backend_pi.core.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yavirac.logistics_backend_pi.core.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @SuppressWarnings("null")
    List<Hotel> findAll();
}
