package com.example.springevodemo.controller;

import com.example.springevodemo.model.AuthResponse;
import com.example.springevodemo.model.UserDto;
import com.example.springevodemo.service.JwtService;
import com.example.springevodemo.service.UserDetailServiceImpl;
import com.example.springevodemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailServiceImpl userDetailService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public void createUser(@RequestBody UserDto user) {
        userService.createUser(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserDto req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
        );

        var userDetails = userDetailService.loadUserByUsername(req.getUsername());
        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token);
    }
}
