package com.hori.instagram_clone_api.auth.dto.response;

public record RegisterResponse(
    String username,
    String email,
    String phoneNumber
) {}
