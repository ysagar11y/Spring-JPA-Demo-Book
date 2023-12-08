package com.jpademo.JpaDemo.security.dao;

import com.jpademo.JpaDemo.response.JwtAuthenticationResponse;
import com.jpademo.JpaDemo.response.SignUpRequest;
import com.jpademo.JpaDemo.response.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}