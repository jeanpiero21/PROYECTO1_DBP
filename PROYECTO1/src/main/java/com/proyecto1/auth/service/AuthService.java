package com.proyecto1.auth.service;

import com.proyecto1.auth.dto.request.*;
import com.proyecto1.auth.dto.response.*;

public interface AuthService {
    UserResponse register(RegisterRequest dto);
    AuthResponse login(LoginRequest dto);
}
