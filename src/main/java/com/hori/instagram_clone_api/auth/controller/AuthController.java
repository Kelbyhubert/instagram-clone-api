package com.hori.instagram_clone_api.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hori.instagram_clone_api.auth.dto.request.LoginRequest;
import com.hori.instagram_clone_api.auth.dto.request.RegisterRequest;
import com.hori.instagram_clone_api.auth.dto.response.AuthResponse;
import com.hori.instagram_clone_api.auth.service.AuthService;

import com.hori.instagram_clone_api.global.response.ApiResponse;
import com.hori.instagram_clone_api.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final AuthService authService;

    @PostMapping(
        value = "/authenticate",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtils.generateJwtToken(authentication);

        ApiResponse<AuthResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setData(new AuthResponse(jwtToken));
        apiResponse.setMessage("Login Success");

        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping(
        value = "/register",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<String>> Register(@RequestBody RegisterRequest request) {
        authService.register(request);

        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.CREATED.value());
        apiResponse.setMessage("Success Create User");

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

}
