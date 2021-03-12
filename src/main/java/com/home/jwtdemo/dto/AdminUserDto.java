package com.home.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.home.jwtdemo.entity.Status;
import com.home.jwtdemo.entity.UserEntity;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String status;

    public UserEntity toUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setUsername(username);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setStatus(Status.valueOf(status));

        return userEntity;
    }

    public static AdminUserDto fromUserEntity(UserEntity userEntity) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(userEntity.getId());
        adminUserDto.setUsername(userEntity.getUsername());
        adminUserDto.setFirstName(userEntity.getFirstName());
        adminUserDto.setLastName(userEntity.getLastName());
        adminUserDto.setEmail(userEntity.getEmail());
        adminUserDto.setStatus(userEntity.getStatus().name());

        return adminUserDto;
    }
}
