package com.example.springevodemo.service;

import com.example.springevodemo.dao.UserRepository;
import com.example.springevodemo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity = userRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundException("User not found with username: " + username)
        );

        var roles = userEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().toString()))
                .toList();

        return new User(userEntity.getUsername(), userEntity.getPassword(), roles);
    }
}
