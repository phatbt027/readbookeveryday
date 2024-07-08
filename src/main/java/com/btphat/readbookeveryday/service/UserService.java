package com.btphat.readbookeveryday.service;

import java.util.List;

import com.btphat.readbookeveryday.dto.user.UserDto;
import com.btphat.readbookeveryday.entity.User;

public interface UserService {
    
    public User saveUser(final UserDto userDto);

    public User updateUser(final UserDto userDto);

    public void deleteUser(final UserDto userDto);

    public List<User> getAllUser();

    public User disableUser(final UserDto userDto);

    public User findUserByUsername(final UserDto userDto);
}
