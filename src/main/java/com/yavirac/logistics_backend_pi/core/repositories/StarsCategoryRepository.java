package com.yavirac.logistics_backend_pi.core.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yavirac.logistics_backend_pi.core.entities.StarsCategory;

public interface StarsCategoryRepository extends JpaRepository<StarsCategory, Long> {
    @SuppressWarnings("null")
    List<StarsCategory> findAll();
}
