package com.home.jwtdemo.security.jwt;

import com.home.jwtdemo.entity.Role;
import com.home.jwtdemo.entity.Status;
import com.home.jwtdemo.entity.UserEntity;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public final class JwtUserFactory {

    public static JwtUser jwtUserFromUserEntity(UserEntity userEntity) {
        return new JwtUser(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getStatus().equals(Status.ACTIVE), // enabled only user status equals ACTIVE
                userEntity.getUpdated(),
                mapToGratedAuthorities(new ArrayList<>(userEntity.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGratedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
