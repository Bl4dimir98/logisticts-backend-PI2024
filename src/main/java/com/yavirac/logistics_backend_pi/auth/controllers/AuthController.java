package com.yavirac.logistics_backend_pi.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yavirac.logistics_backend_pi.auth.models.AuthResponse;
import com.yavirac.logistics_backend_pi.auth.models.LoginRequest;
import com.yavirac.logistics_backend_pi.auth.models.RegisterRequest;
import com.yavirac.logistics_backend_pi.auth.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "auth/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(value = "admin")
    public ResponseEntity<AuthResponse> registerAdmin(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerAdmin(request));
    }

    @PostMapping(value = "driver")
    public ResponseEntity<AuthResponse> registerDriver(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerDriver(request));
    }

    @PostMapping(value = "guide")
    public ResponseEntity<AuthResponse> registerGuide(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerGuide(request));
    };

}
