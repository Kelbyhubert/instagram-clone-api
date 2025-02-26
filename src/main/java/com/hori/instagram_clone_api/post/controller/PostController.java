package com.hori.instagram_clone_api.post.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hori.instagram_clone_api.comment.dto.request.CreateCommentDto;
import com.hori.instagram_clone_api.comment.dto.response.CommentDto;
import com.hori.instagram_clone_api.comment.model.Comment;
import com.hori.instagram_clone_api.global.response.ApiResponse;
import com.hori.instagram_clone_api.post.dto.request.CreatePostDto;
import com.hori.instagram_clone_api.post.dto.response.PostDto;
import com.hori.instagram_clone_api.post.model.Post;
import com.hori.instagram_clone_api.post.service.PostService;
import com.hori.instagram_clone_api.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping(value =  "/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    
    private final PostService postService;
    private final JwtUtils jwtUtils;

    @PostMapping(
        value =  "",
        consumes =  MediaType.APPLICATION_JSON_VALUE,
        produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<PostDto>> createPost(@RequestBody CreatePostDto request) {
        Post post =  postService.createPost(request);

        ApiResponse<PostDto> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.CREATED.value());
        apiResponse.setData(PostDto.from(post, 0L, 0L, false));
        apiResponse.setMessage("Successfully create new post");

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping(
        value =  "",
        produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<List<PostDto>>> getPostList(
                                @RequestParam(defaultValue = "0") int offset,
                                @RequestParam(defaultValue = "10") int limit,
                                @RequestHeader("Authorization") String token
                                ) {


        Long userId = jwtUtils.getTokenSubject(token);

        ApiResponse<List<PostDto>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setData(postService.getPostList(userId,offset,limit));
        apiResponse.setMessage("Successfully fetched posts");

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


    // comment 
    @PostMapping(
        value =  "/{id}/comment",
        consumes =  MediaType.APPLICATION_JSON_VALUE,
        produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<CommentDto>> addCommentToPost(
                                                                @PathVariable Long id, 
                                                                @RequestBody CreateCommentDto request,
                                                                @RequestHeader("Authorization") String token) {

        Long userId = jwtUtils.getTokenSubject(token);
        Comment comment = postService.commentPost(id,userId,request); 
                                                                    
        ApiResponse<CommentDto> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.CREATED.value());
        apiResponse.setData(CommentDto.from(comment.getId(), comment.getUser(), comment.getComment()));
        apiResponse.setMessage("Successfully comment post for ID : " + id);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @GetMapping(
        value =  "/{id}/comments",
        produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<List<CommentDto>>> getPostComment(@PathVariable Long id) {

        List<Comment> comments = postService.getPostComments(id); 
                              
        List<CommentDto> commentDtos = comments.stream()
                                        .map(comment -> CommentDto.from(comment.getId(), comment.getUser(), comment.getComment()))
                                        .toList();

        ApiResponse<List<CommentDto>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setData(commentDtos);
        apiResponse.setMessage("Successfully fetched comments for post with ID: " + id);
        
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    //like
    @PostMapping(
        value =  "/{id}/like",
        produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<String>> likePost(
                                                        @PathVariable Long id, 
                                                        @RequestHeader("Authorization") String token) {

        Long userId = jwtUtils.getTokenSubject(token);
        postService.likePost(id, userId);                        
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.CREATED.value());
        apiResponse.setMessage("Successfully liked post with ID: " + id);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @DeleteMapping(
        value =  "/{id}/like",
        produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<String>> unlikePost(
                                                        @PathVariable Long id, 
                                                        @RequestHeader("Authorization") String token) {

        Long userId = jwtUtils.getTokenSubject(token);
        postService.unlikePost(id, userId);                        
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setMessage("Successfully unliked post with ID: " + id);
        
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    

    
    
}
