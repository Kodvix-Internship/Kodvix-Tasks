package com.example.studenttask.service;

import com.example.studenttask.dto.AuthResponse;
import com.example.studenttask.dto.LoginRequest;
import com.example.studenttask.dto.RegisterRequest;

public interface AuthService {

    void register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
