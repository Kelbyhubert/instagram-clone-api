package com.hori.instagram_clone_api.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hori.instagram_clone_api.global.exception.NotFoundException;
import com.hori.instagram_clone_api.post.dto.response.PostDto;
import com.hori.instagram_clone_api.user.exception.CreateUserException;
import com.hori.instagram_clone_api.user.model.User;
import com.hori.instagram_clone_api.user.repository.UserRepository;
import com.hori.instagram_clone_api.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public User getUserDetails(Long id) {
        return userRepository.findById(id).orElseThrow(
            () -> new NotFoundException( "User Not Found")
        );
    }



    @Override
    public User getUserDetails(String username, String phoneNumber, String email) {
        return userRepository.findByUsernameOrEmailOrPhoneNumber(username, username, username).orElseThrow(
            () -> new NotFoundException( "User Not Found")
        );
    }

    @Override
    public void createUser(String username, String password, String phoneNumber,String email) {
        // validasi user
        validateCreateUser(username, email ,phoneNumber);

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);

    }


    private void validateCreateUser(String username,String email, String phoneNumber) {
        Map<String,Object> errors = new HashMap<>();
        if(userRepository.existsByUsername(username)){
            errors.put("username", "username have been register");
        }
        if(userRepository.existsByEmail(email)){
            errors.put("email", "email have been register");
        }
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            errors.put("phoneNumber", "phone number have been register");
        }
        
        if(!errors.isEmpty()){
            throw new CreateUserException(errors, "Failed Create User");
        }
    
    }

    @Override
    public List<PostDto> getUserPostList(Long userId) {
        User user = getUserDetails(userId);

        List<PostDto> postDtos = user.getPosts().stream()
                                        .map(post -> PostDto
                                            .from(
                                                post, 
                                                (long) post.getComments().size(), 
                                                (long) post.getLikes().size(), 
                                                user.getLikedPosts().contains(post)
                                            )
                                        ).toList();
        return postDtos;
    }




    
}
