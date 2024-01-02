package com.aipainter.authenticationservice.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/login")
    public String login(OAuth2AuthenticationToken authentication) {
    System.out.println(authentication);
        return "Trying to log in..";
    }

    @GetMapping("/orders")
    public String orders() {
        return "Orders page...";
    }
    @GetMapping("/home")
    public String homePage() {
        return "Hello World!";
    }
}
