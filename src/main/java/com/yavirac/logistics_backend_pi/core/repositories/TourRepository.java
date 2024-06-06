package com.yavirac.logistics_backend_pi.core.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yavirac.logistics_backend_pi.core.entities.Tour;

public interface TourRepository extends JpaRepository<Tour, Long>{
    @SuppressWarnings("null")
    List<Tour> findAll();
}
