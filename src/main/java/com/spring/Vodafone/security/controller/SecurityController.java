package com.spring.Vodafone.security.controller;

import com.spring.Vodafone.exception.exceptions.UserExistedException;
import com.spring.Vodafone.security.model.dto.AuthenticationRequest;
import com.spring.Vodafone.security.model.dto.AuthenticationResponse;
import com.spring.Vodafone.security.model.entity.AppUser;
import com.spring.Vodafone.security.service.AuthenticationService;
import com.spring.Vodafone.security.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SecurityController {

    private final AuthenticationService authenticationService;
    private final UserServices userServices;


    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws Exception {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody AppUser user) {
        for (AppUser users : userServices.findAll()) {
            if (users.getUsername().equals(user.getUsername())) {
                throw new UserExistedException("This username ( " + user.getUsername() + " ) is exist");
            }
        }
        userServices.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}

