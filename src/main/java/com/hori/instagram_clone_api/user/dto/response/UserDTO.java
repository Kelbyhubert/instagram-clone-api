package com.hori.instagram_clone_api.user.dto.response;

public record UserDTO(
    Long id,
    String username,
    String profilePictureUrl
) {}