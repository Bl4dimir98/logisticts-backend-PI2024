package com.yavirac.logistics_backend_pi.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yavirac.logistics_backend_pi.auth.jwt.JwtService;
import com.yavirac.logistics_backend_pi.auth.models.AuthResponse;
import com.yavirac.logistics_backend_pi.auth.models.LoginRequest;
import com.yavirac.logistics_backend_pi.auth.models.RegisterRequest;
import com.yavirac.logistics_backend_pi.auth.user.Role;
import com.yavirac.logistics_backend_pi.auth.user.User;
import com.yavirac.logistics_backend_pi.auth.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final UserRepository userRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
                authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
        }

        // Registrar Usuarios con rol USER
        public AuthResponse register(RegisterRequest request) {
                User user = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .fullnames(request.getFullnames())
                                .lastnames(request.getLastnames())
                                .dni(request.getDni())
                                .phone(request.getPhone())
                                .email(request.getEmail())
                                .address(request.getAddress())
                                .genre(request.getGenre())
                                .bloodType(request.getBloodType())
                                .birthday(request.getBirthday())
                                .maritalState(request.getMaritalState())
                                .emergencyContact(request.getEmergencyContact())
                                .emergencyPhone(request.getEmergencyPhone())
                                .disease(request.getDisease())
                                .disability(request.getDisability())
                                .enable(request.getEnable())
                                .role(Role.USER)
                                .build();
                userRepository.save(user);
                return AuthResponse.builder()
                                .build();
        };

        // Registrar Usuarios con rol ADMIN
        public AuthResponse registerAdmin(RegisterRequest request) {
                User admin = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .fullnames(request.getFullnames())
                                .lastnames(request.getLastnames())
                                .dni(request.getDni())
                                .phone(request.getPhone())
                                .email(request.getEmail())
                                .address(request.getAddress())
                                .genre(request.getGenre())
                                .bloodType(request.getBloodType())
                                .birthday(request.getBirthday())
                                .maritalState(request.getMaritalState())
                                .emergencyContact(request.getEmergencyContact())
                                .emergencyPhone(request.getEmergencyPhone())
                                .disease(request.getDisease())
                                .disability(request.getDisability())
                                .enable(request.getEnable())
                                .role(Role.ADMIN)
                                .build();
                userRepository.save(admin);
                return AuthResponse.builder()
                                .build();
        };

        // Registrar Usuarios con rol DRIVER
        public AuthResponse registerDriver(RegisterRequest request) {
                User driver = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .fullnames(request.getFullnames())
                                .lastnames(request.getLastnames())
                                .dni(request.getDni())
                                .phone(request.getPhone())
                                .email(request.getEmail())
                                .address(request.getAddress())
                                .genre(request.getGenre())
                                .bloodType(request.getBloodType())
                                .birthday(request.getBirthday())
                                .maritalState(request.getMaritalState())
                                .emergencyContact(request.getEmergencyContact())
                                .emergencyPhone(request.getEmergencyPhone())
                                .disease(request.getDisease())
                                .disability(request.getDisability())
                                .enable(request.getEnable())
                                .role(Role.DRIVER)
                                .build();
                userRepository.save(driver);
                return AuthResponse.builder()
                                .build();
        };

        // Registrar Usuarios con rol GUIDE
        public AuthResponse registerGuide(RegisterRequest request) {
                User guide = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .fullnames(request.getFullnames())
                                .lastnames(request.getLastnames())
                                .dni(request.getDni())
                                .phone(request.getPhone())
                                .email(request.getEmail())
                                .address(request.getAddress())
                                .genre(request.getGenre())
                                .bloodType(request.getBloodType())
                                .birthday(request.getBirthday())
                                .maritalState(request.getMaritalState())
                                .emergencyContact(request.getEmergencyContact())
                                .emergencyPhone(request.getEmergencyPhone())
                                .disease(request.getDisease())
                                .disability(request.getDisability())
                                .enable(request.getEnable())
                                .role(Role.GUIDE)
                                .build();
                userRepository.save(guide);
                return AuthResponse.builder()
                                .build();
        };
        
}
