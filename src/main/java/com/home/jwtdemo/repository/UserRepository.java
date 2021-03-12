package com.home.jwtdemo.repository;

import com.home.jwtdemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username); // find our User by users login
}
