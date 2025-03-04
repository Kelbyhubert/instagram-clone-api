package com.hori.instagram_clone_api.user.dto.response;

public record UserDetailDto(
    Long id,
    String username,
    String email,
    String phoneNumber,
    String profilePictureUrl,
    Long roleId
) {}