package com.hori.instagram_clone_api.user.dto.request;

public record CreateUserRequest(
    String username,
    String email,
    String phoneNumber,
    String password
) {}
