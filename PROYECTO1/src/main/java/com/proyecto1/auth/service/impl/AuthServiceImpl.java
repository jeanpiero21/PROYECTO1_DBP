package com.proyecto1.auth.service.impl;

import com.proyecto1.auth.dto.AuthResponse;
import com.proyecto1.auth.dto.LoginRequest;
import com.proyecto1.auth.dto.RegisterRequest;
import com.proyecto1.auth.dto.UserResponse;
import com.proyecto1.auth.entity.User;
import com.proyecto1.auth.repository.UserRepository;
import com.proyecto1.auth.service.AuthService;
import com.proyecto1.common.enums.Role;
import com.proyecto1.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    @Override
    public UserResponse register(RegisterRequest dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Role.STUDENT)
                .build();

        User saved = userRepository.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRole()
        );
    }

    @Override
    public AuthResponse login(LoginRequest dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        java.util.Collections.emptyList()
                ),
                user.getRole().name()
        );

        return new AuthResponse(token, jwtExpiration);
    }
}
