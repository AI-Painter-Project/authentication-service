package com.aipainter.authenticationservice.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("secrets")
@Getter
@Setter
public class Secrets {
    private String oktaIssuer;
    private String oktaClientKey;
    private String oktaClientSecret;
}
