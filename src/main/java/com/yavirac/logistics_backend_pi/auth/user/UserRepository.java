package com.yavirac.logistics_backend_pi.auth.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @SuppressWarnings("null")
    List<User> findAll();
}
