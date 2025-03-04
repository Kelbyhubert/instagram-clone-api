package com.hori.instagram_clone_api.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hori.instagram_clone_api.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    
}
