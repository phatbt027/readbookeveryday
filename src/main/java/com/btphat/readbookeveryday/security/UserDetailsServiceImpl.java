package com.btphat.readbookeveryday.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.btphat.readbookeveryday.entity.User;
import com.btphat.readbookeveryday.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        
        final User user = userRepository.findUserByUsername(username).
            orElseThrow(() -> new UsernameNotFoundException("User not found!!!"));

        return new MyUserDetails(user);
    }
    
}
