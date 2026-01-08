package com.example.springevodemo.service;

import com.example.springevodemo.dao.RoleEntity;
import com.example.springevodemo.dao.UserEntity;
import com.example.springevodemo.dao.UserRepository;
import com.example.springevodemo.enums.Role;
import com.example.springevodemo.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(@RequestBody UserDto user) {
        RoleEntity roleEntity = RoleEntity.builder()
                .role(Role.ROLE_USER)
                .build();

        UserEntity userEntity = UserEntity.builder().username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(Collections.singletonList(roleEntity))
                .build();

        roleEntity.setUser(userEntity);
        userRepository.save(userEntity);
    }
}
