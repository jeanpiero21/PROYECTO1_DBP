package com.proyecto1.auth.service;

import com.proyecto1.auth.dto.AuthResponse;
import com.proyecto1.auth.dto.LoginRequest;
import com.proyecto1.auth.dto.RegisterRequest;
import com.proyecto1.auth.dto.UserResponse;

public interface AuthService {
    UserResponse register(RegisterRequest dto);
    AuthResponse login(LoginRequest dto);
}
