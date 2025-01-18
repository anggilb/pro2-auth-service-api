package com.example.auth_service_api.service;

import com.example.auth_service_api.commons.dtos.TokenResponse;
import io.jsonwebtoken.Claims;

public interface JwtService {
    TokenResponse generateToken(Long userId);
    Claims getClaims(String token);
    boolean isExpired(String token);
    Integer extractedUserId(String token);
}
