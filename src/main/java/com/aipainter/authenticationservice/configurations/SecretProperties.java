package com.aipainter.authenticationservice.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created to manage secrets, this helps in creating a .gitIgnored file containing the secrets.
 * Secrets config file is injected in the application.yml to access them
 *
 * @author srijan.srivastav.personal@gmail.com
 */
@ConfigurationProperties("secrets")
@Getter
@Setter
public class SecretProperties {
    private String oktaIssuer;
    private String oktaClientKey;
    private String oktaClientSecret;
    private String dbUrl;
    private String dbUserMySql;
    private String dbPasswordMySql;
}
