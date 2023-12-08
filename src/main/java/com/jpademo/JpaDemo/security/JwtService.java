package com.jpademo.JpaDemo.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    //for getting username from db
    String extractUserName(String token);

    //for generating token
    String generateToken(UserDetails userDetails);

    //to check valadity
    boolean isTokenValid(String token, UserDetails userDetails);
}