package com.proyecto1.auth.controller;

import com.proyecto1.auth.dto.request.*;
import com.proyecto1.auth.dto.response.*;
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
