package com.aipainter.authenticationservice;

import com.aipainter.authenticationservice.configurations.SecretProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Authentication service start up point
 *
 * @author srijan.srivastav.personal@gmail.com
 */
@SpringBootApplication
@EnableConfigurationProperties(SecretProperties.class)
public class AuthenticationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}
}
