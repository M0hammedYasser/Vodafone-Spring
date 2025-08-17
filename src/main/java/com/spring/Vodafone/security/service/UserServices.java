package com.spring.Vodafone.security.service;

import com.spring.Vodafone.security.model.entity.AppUser;
import com.spring.Vodafone.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    public AppUser save(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }



}
