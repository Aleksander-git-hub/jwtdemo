package com.home.jwtdemo.security;

import com.home.jwtdemo.entity.UserEntity;
import com.home.jwtdemo.security.jwt.JwtUser;
import com.home.jwtdemo.security.jwt.JwtUserFactory;
import com.home.jwtdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found!");
        }

        JwtUser jwtUser = JwtUserFactory.jwtUserFromUserEntity(user);

        log.info("IN loadByUsername - user with username: {} successfully loaded", username);

        return jwtUser;
    }
}
