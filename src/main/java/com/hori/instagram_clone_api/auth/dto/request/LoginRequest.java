package com.hori.instagram_clone_api.auth.dto.request;

public record LoginRequest(
    String username,
    String password
) {}
