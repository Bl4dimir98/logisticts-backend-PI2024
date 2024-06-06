package com.yavirac.logistics_backend_pi.core.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yavirac.logistics_backend_pi.core.entities.Transport;

public interface TransportRepository extends JpaRepository<Transport, Long> {
    @SuppressWarnings("null")
    List<Transport> findAll();
}
