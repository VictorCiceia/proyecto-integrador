package com.proyecto.integrador.integrador.service;


import com.proyecto.integrador.integrador.config.jwt.JwtService;
import com.proyecto.integrador.integrador.dto.auth.AuthResponseDto;
import com.proyecto.integrador.integrador.dto.auth.LoginRequestDto;
import com.proyecto.integrador.integrador.dto.auth.RegisterRequestDto;
import com.proyecto.integrador.integrador.entity.UserEntity;
import com.proyecto.integrador.integrador.repository.UserRepository;
import com.proyecto.integrador.integrador.util.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDto login(LoginRequestDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByEmail(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponseDto.builder()
                .token(token)
                .build();

    }

    public AuthResponseDto register(RegisterRequestDto request) {
        UserEntity user = UserEntity.builder()
                .email(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .name(request.getFirstname())
                .lastName(request.getLastname())
                .role(Role.USER)
                .createdAt(new Date())
                .build();

        userRepository.save(user);

        return AuthResponseDto.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}