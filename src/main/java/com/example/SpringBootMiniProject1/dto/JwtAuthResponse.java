package com.example.SpringBootMiniProject1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Response for the jwt security added
public class JwtAuthResponse {
    private  String accessToken;
    private  String tokenType="Bearer";
    private String role;
}