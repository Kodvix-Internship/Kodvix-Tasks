package com.example.studenttask.service;

import com.example.studenttask.dto.*;
import com.example.studenttask.entity.Role;
import com.example.studenttask.entity.User;
import com.example.studenttask.repository.UserRepository;
import com.example.studenttask.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public void register(RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(Role.USER);   // ✅ IMPORTANT

        userRepository.save(user);
    }


    @Override
    public AuthResponse login(LoginRequest request) {

        // 🔥 Authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // 🔥 Generate JWT automatically
        String token = jwtUtil.generateToken(request.getUsername());

        return new AuthResponse(token);
    }
}
