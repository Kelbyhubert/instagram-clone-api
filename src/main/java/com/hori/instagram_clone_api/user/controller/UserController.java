package com.hori.instagram_clone_api.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hori.instagram_clone_api.global.response.ApiResponse;
import com.hori.instagram_clone_api.post.dto.response.PostDto;
import com.hori.instagram_clone_api.user.dto.response.UserDetailDto;
import com.hori.instagram_clone_api.user.model.User;
import com.hori.instagram_clone_api.user.service.UserService;
import com.hori.instagram_clone_api.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserDetailDto>> getUserDetail(@PathVariable Long id) {
        User user = userService.getUserDetails(id);

        ApiResponse<UserDetailDto> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setData(userDetailDtoMapper(user));
        apiResponse.setMessage("Success Get User");

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(
        value = "/me",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserDetailDto>> getAuthenticateUser(@RequestHeader("Authorization") String token) {

        Long id = jwtUtils.getTokenSubject(token);
        User user = userService.getUserDetails(id);

        ApiResponse<UserDetailDto> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setData(userDetailDtoMapper(user));
        apiResponse.setMessage("Success Get User");

        return ResponseEntity.ok(apiResponse);
    }

    private UserDetailDto userDetailDtoMapper(User user) {
        return new UserDetailDto(user.getId(), user.getUsername(), user.getEmail(), user.getPhoneNumber(), user.getProfilePicture());
    }

    @GetMapping(
        value =  "/{id}/posts",
        produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<List<PostDto>>> getUserPost(@PathVariable Long id) {

        ApiResponse<List<PostDto>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("Success");
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setData(userService.getUserPostList(id));
        apiResponse.setMessage("Successfully fetched posts");

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    

}
