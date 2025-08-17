package com.spring.Vodafone.security.service;

import com.spring.Vodafone.exception.exceptions.InvalidPasswordException;
import com.spring.Vodafone.exception.exceptions.RecordNotFountException;
import com.spring.Vodafone.security.model.dto.AuthenticationRequest;
import com.spring.Vodafone.security.model.dto.AuthenticationResponse;
import com.spring.Vodafone.security.model.entity.AppUser;
import com.spring.Vodafone.security.repository.UserRepository;
import com.spring.Vodafone.security.jwt.JwtServices;
import com.spring.Vodafone.security.model.AppUserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final JwtServices jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        AppUser user = repository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RecordNotFountException("invalid username"));

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new InvalidPasswordException("invalid password");
        }


        var jwtToken = jwtService.generateToken(new AppUserDetail(user));

        return AuthenticationResponse.builder()
                .id(user.getId())
                .Token(jwtToken)
                .build();
    }
}