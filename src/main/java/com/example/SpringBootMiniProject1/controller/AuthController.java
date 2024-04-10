package com.example.SpringBootMiniProject1.controller;

import com.example.SpringBootMiniProject1.dto.JwtAuthResponse;
import com.example.SpringBootMiniProject1.dto.LoginDto;
import com.example.SpringBootMiniProject1.dto.RegisterDto;
import com.example.SpringBootMiniProject1.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private AuthService authService;

    //controller endpoints for login
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        JwtAuthResponse jwtAuthResponse = authService.login(loginDto);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
    //controller endpoints for login and register form

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto)
    {
        String response1=authService.register(registerDto);
        return response1;
    }

}
