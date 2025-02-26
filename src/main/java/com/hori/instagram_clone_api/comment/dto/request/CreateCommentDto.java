package com.hori.instagram_clone_api.comment.dto.request;


public record CreateCommentDto(
    Long parentCommentId,
    String comment
) {}