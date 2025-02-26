package com.hori.instagram_clone_api.comment.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hori.instagram_clone_api.comment.service.CommentService;
import com.hori.instagram_clone_api.global.response.ApiResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor

public class CommentController {
    
    private final CommentService commentService;

    @PostMapping(
        value =  "/{id}/reply",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<?>> replyComment(@RequestBody String entity) {
        //TODO: process POST request
        
        return ResponseEntity.ok(null);
    }
    

}
