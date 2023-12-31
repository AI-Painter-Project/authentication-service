package com.aipainter.authenticationservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/home").permitAll())
        .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
        // OAuth2 Login handles the redirect to the OAuth 2.0 Login endpoint
        // from the authorization server filter chain
        .oauth2Login(Customizer.withDefaults());

    return http.build();
  }
}
