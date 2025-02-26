package com.hori.instagram_clone_api.global.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
    int status,
    Map<String,Object> errors,
    String message
) {}
