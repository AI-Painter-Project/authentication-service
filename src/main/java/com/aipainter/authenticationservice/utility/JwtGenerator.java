package com.aipainter.authenticationservice.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.util.List;
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
  public static String createJwt(OidcUser user) {
    return JWT.create()
        .withIssuer("ai-painter-authentication-service")
        .withAudience(user.getName())
        .withIssuedAt(Instant.now())
        .withExpiresAt(Instant.now().plusSeconds(30 * 60))
        .withSubject(user.getSubject())
        .withClaim("name", user.getFullName())
        .withClaim("email", user.getEmail())
        .withClaim("roles", assignRoles(user.getEmail()))
        .sign(Algorithm.none());
  }

  private static List<String> assignRoles(String email) {
    return "srijan.srivastav.personal@gmail.com".equals(email) ? List.of("admin") : List.of("user");
  }
}
