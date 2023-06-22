package com.uep.wap.controller;

import com.uep.wap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        String username = user.getUsername();
        String rawPassword = user.getPassword();

        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);

        // save username and encodedPassword to your database

        return "redirect:/login";
    }
}

