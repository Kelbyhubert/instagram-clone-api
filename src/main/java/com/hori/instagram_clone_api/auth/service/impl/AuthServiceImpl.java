package com.hori.instagram_clone_api.auth.service.impl;

import org.springframework.stereotype.Service;


import com.hori.instagram_clone_api.auth.dto.request.RegisterRequest;

import com.hori.instagram_clone_api.auth.service.AuthService;
import com.hori.instagram_clone_api.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    @Override
    public void register(RegisterRequest request) {
        userService.createUser(request.username(),request.password(),request.phoneNumber(),request.email());
    }

    
}
