package com.aipainter.authenticationservice.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

/**
 * Creates a custom JWT cookie that will be used for subsequent API access across services.
 * JWT token attached to cookie is short-lived
 *
 * @author srijan.srivastav
 */
@Component
public final class JwtGenerator {
  public String createJwt(Authentication authentication) {
    OidcUser user = (OidcUser) authentication.getPrincipal();
    return JWT.create()
        .withIssuer("ai-painter-authentication-service")
        .withAudience(user.getName())
        .withIssuedAt(Instant.now())
        .withExpiresAt(Instant.now().plusSeconds(30 * 60))
        .withSubject(user.getSubject())
        .withClaim("name", user.getName())
        .withClaim("email", user.getEmail())
        .withClaim("roles", List.of("admin"))
        .sign(Algorithm.none());
  }
}
