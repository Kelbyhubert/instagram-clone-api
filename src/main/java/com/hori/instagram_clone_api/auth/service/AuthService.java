package com.hori.instagram_clone_api.auth.service;


import com.hori.instagram_clone_api.auth.dto.request.RegisterRequest;

public interface AuthService {
    
    public void register(RegisterRequest request);
}
