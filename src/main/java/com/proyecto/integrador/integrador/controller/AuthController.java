package com.proyecto.integrador.integrador.controller;

import com.proyecto.integrador.integrador.dto.auth.AuthResponseDto;
import com.proyecto.integrador.integrador.dto.auth.LoginRequestDto;
import com.proyecto.integrador.integrador.dto.auth.RegisterRequestDto;
import com.proyecto.integrador.integrador.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}