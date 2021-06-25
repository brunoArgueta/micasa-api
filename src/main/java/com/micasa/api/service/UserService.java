package com.micasa.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    public UserDetails getUserDetails(String email) {
        return jdbcUserDetailsManager.loadUserByUsername(email);
    }

}
