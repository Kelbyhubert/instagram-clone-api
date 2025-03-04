package com.hori.instagram_clone_api.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hori.instagram_clone_api.user.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
    public Optional<User> findByUsernameOrEmailOrPhoneNumber(String username, String email, String phoneNumber);
    public boolean existsByUsername(String username);
    
    public boolean existsByEmail(String email);
    
    public boolean existsByPhoneNumber(String phoneNumber);

}
