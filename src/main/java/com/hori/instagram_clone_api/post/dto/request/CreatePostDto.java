package com.hori.instagram_clone_api.post.dto.request;

public record CreatePostDto(
    Long userId,
    String imageUrl,
    String caption
) {}
