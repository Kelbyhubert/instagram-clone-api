package com.hori.instagram_clone_api.user.service;

import java.util.List;

import com.hori.instagram_clone_api.post.dto.response.PostDto;
import com.hori.instagram_clone_api.user.model.User;

public interface UserService {
    
    public void createUser(String username, String password, String phoneNumber,String email);
    public User getUserDetails(Long id);
    public User getUserDetails(String username, String phoneNumber, String email);
    public List<PostDto> getUserPostList(Long userId);
    
}
