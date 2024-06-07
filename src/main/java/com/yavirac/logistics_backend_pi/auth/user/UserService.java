package com.yavirac.logistics_backend_pi.auth.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Get All
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Get By Id
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
