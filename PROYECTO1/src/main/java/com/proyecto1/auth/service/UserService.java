package com.proyecto1.auth.service;

import com.proyecto1.auth.dto.UserResponse;

public interface UserService {
    UserResponse getProfile(String email);
}
