package com.btphat.readbookeveryday.dto.user;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.btphat.readbookeveryday.entity.User;

@Service
public class UserDtoMapper implements Function<User, UserDto> {

    @Override
    public UserDto apply(User user) {
        return new UserDto(
            user.getId(), 
            user.getUsername(), 
            user.getPassword());
    }
    
}
