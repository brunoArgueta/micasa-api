package com.micasa.api.controller;

import com.micasa.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String login(@RequestParam(value = "email") String email){
        UserDetails userDetails = userService.getUserDetails(email);
        return "ok";
    }
}
