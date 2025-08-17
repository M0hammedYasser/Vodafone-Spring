package com.spring.Vodafone.security.model;


import com.spring.Vodafone.security.model.entity.AppUser;
import com.spring.Vodafone.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(AppUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("This User '" + username + "' NotFound"));
    }

}
