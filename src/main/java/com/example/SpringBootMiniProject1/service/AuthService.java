package com.example.SpringBootMiniProject1.service;



import com.example.SpringBootMiniProject1.dto.JwtAuthResponse;
import com.example.SpringBootMiniProject1.dto.LoginDto;
import com.example.SpringBootMiniProject1.dto.RegisterDto;

import java.util.List;

public interface AuthService {



    JwtAuthResponse login(LoginDto loginDto);


    String register(RegisterDto registerDto);

}