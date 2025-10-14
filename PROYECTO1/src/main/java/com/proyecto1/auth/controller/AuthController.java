package com.proyecto1.auth.controller;

import com.proyecto1.auth.dto.AuthResponse;
import com.proyecto1.auth.dto.LoginRequest;
import com.proyecto1.auth.dto.RegisterRequest;
import com.proyecto1.auth.dto.UserResponse;
import com.proyecto1.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest dto) {
        return ResponseEntity.status(201).body(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
}
