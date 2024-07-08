package com.btphat.readbookeveryday.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.btphat.readbookeveryday.dto.user.UserDto;
import com.btphat.readbookeveryday.dto.user.UserDtoMapper;
import com.btphat.readbookeveryday.entity.Role;
import com.btphat.readbookeveryday.entity.User;
import com.btphat.readbookeveryday.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDtoMapper userDtoMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(final UserDto userDto) {
        
        return userRepository.save(userDtoMapToUser(userDto));
    }

    @Override
    public User updateUser(final UserDto userDto) {
        
        final User user = findUserByUsername(userDto);

        userDtoMapToUser(userDto);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(final UserDto userDto) {
        
        final User user = findUserByUsername(userDto);
        
        userRepository.delete(user);
    }

    @Override
    public List<User> getAllUser() {
        
        return userRepository.findAll();
    }

    @Override
    public User disableUser(final UserDto userDto) {
        
        final User user = findUserByUsername(userDto);

        user.setEnabled(false);

        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(final UserDto userDto) {
        
        return userRepository.findUserByUsername(userDto.username())
            .orElseThrow(() -> new UsernameNotFoundException("User not found!!!"));
    }
    
    private User userDtoMapToUser(final UserDto userDto) {

        final User user = new User();
        user.setUsername(userDto.username());
        user.setPassword(userDto.password());
        user.setRole(Role.USER);
        user.setEnabled(true);

        return user;
    }
}
