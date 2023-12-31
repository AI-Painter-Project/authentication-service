package com.aipainter.authenticationservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/login")
    public String login() {
        return "Trying to log in..";
    }
    @GetMapping("/home")
    public String homePage() {
        return "Hello World!";
    }
}
