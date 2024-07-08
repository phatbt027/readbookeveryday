package com.btphat.readbookeveryday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.btphat.readbookeveryday.dto.user.UserDto;
import com.btphat.readbookeveryday.entity.User;
import com.btphat.readbookeveryday.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> index() {

        return userService.getAllUser();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User save(@ModelAttribute UserDto userDto) {

        return userService.saveUser(userDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public User update(@ModelAttribute UserDto userDto) {

        return userService.saveUser(userDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@ModelAttribute UserDto userDto) {

        userService.deleteUser(userDto);

        return "redirect:/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public User search(@ModelAttribute UserDto userDto) {

        return userService.findUserByUsername(userDto);
    }

    @RequestMapping(value = "/disable", method = RequestMethod.DELETE)
    public User disable(@ModelAttribute UserDto userDto) {

        return userService.disableUser(userDto);
    }
}
