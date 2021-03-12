package com.home.jwtdemo.service;

import com.home.jwtdemo.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity register(UserEntity userEntity);

    List<UserEntity> getAll();

    UserEntity findByUsername(String username);

    UserEntity findById(Long id);

    void delete(Long id);
}
