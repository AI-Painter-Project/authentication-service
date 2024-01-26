package com.aipainter.authenticationservice.configurations;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


/**
 * Security filter chain for managing OAuth2 logins and security configurations with spring security
 *
 * @author srijan.srivastav.personal@gmail.com
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityFilterChainConfig {
  @Autowired
  private final AuthenticationHandler authenticationHandler;
  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
        .oauth2Login(config -> {
          config.successHandler(authenticationHandler::onAuthenticationSuccess);
          config.failureHandler(authenticationHandler::onAuthenticationFailure);
        });
    return http.build();
  }
}
