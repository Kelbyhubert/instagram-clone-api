package com.hori.instagram_clone_api.auth.dto.request;

public record RegisterRequest(
    String username,
    String email,
    String phoneNumber,
    String password
) {}
