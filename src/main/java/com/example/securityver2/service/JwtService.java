package com.example.securityver2.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(String username);
    String extractUserName(String token);

    boolean validateToken(String token, UserDetails userDetails);
}
