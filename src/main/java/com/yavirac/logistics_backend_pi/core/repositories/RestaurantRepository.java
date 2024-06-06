package com.yavirac.logistics_backend_pi.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yavirac.logistics_backend_pi.core.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @SuppressWarnings("null")
    List<Restaurant> findAll();
}
