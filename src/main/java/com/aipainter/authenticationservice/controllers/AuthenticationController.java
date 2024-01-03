package com.aipainter.authenticationservice.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @GetMapping("/home")
    public String homePage() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public OidcUserInfo userInfo(@AuthenticationPrincipal OidcUser principal) {
        return principal.getUserInfo();
    }
}
