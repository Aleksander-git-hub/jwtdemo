package com.home.jwtdemo.controller;

import com.home.jwtdemo.dto.AdminUserDto;
import com.home.jwtdemo.dto.UserDto;
import com.home.jwtdemo.entity.UserEntity;
import com.home.jwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable Long id) {
        UserEntity user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto adminUserDto = AdminUserDto.fromUserEntity(user);

        return new ResponseEntity<>(adminUserDto, HttpStatus.OK);
    }
}
