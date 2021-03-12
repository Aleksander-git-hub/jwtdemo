package com.home.jwtdemo.service.impl;

import com.home.jwtdemo.entity.Role;
import com.home.jwtdemo.entity.Status;
import com.home.jwtdemo.entity.UserEntity;
import com.home.jwtdemo.repository.RoleRepository;
import com.home.jwtdemo.repository.UserRepository;
import com.home.jwtdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity register(UserEntity userEntity) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(userRoles);
        userEntity.setStatus(Status.ACTIVE);

        UserEntity registeredUser = userRepository.save(userEntity);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> users = userRepository.findAll();
        log.info("IN getAll - {} users found", users.size());
        return users;
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity existingUser = userRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username: {}", existingUser, username);
        return existingUser;
    }

    @Override
    public UserEntity findById(Long id) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            log.warn("IN findById - no user found id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} was found by id: {}", existingUser, id);
        return existingUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user was deleted by id: {}", id);
    }
}
