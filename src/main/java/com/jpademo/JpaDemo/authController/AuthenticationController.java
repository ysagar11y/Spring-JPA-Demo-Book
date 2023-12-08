package com.jpademo.JpaDemo.authController;

import com.jpademo.JpaDemo.response.JwtAuthenticationResponse;
import com.jpademo.JpaDemo.response.SignUpRequest;
import com.jpademo.JpaDemo.response.SigninRequest;
import com.jpademo.JpaDemo.security.dao.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v3/auth")
@RequiredArgsConstructor/*

'http://localhost:8080/api/v3/auth/signup' \
body {
    "firstName":"vivek",
    "lastName":"vivekkumar",
    "email": "vivek.kumar@gmail.com",
    "password": "1234"
}

'http://localhost:8080/api/v3/auth/signin' \
'{
    "email": "vivek.kumar@gmail.com",
    "password": "1234"
}
*/
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}