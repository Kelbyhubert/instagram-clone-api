package com.hori.instagram_clone_api.auth.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hori.instagram_clone_api.auth.model.AuthDetail;
import com.hori.instagram_clone_api.global.exception.NotFoundException;
import com.hori.instagram_clone_api.user.model.User;
import com.hori.instagram_clone_api.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmailOrPhoneNumber(username, username, username).orElseThrow(
            () -> new NotFoundException("User Not Found")
        );
        
        AuthDetail authDetail = new AuthDetail(
                                user.getId(),
                                user.getUsername(),
                                user.getPassword()
                            );
        
        return authDetail;
        
    }
}
