package com.aipainter.authenticationservice.configurations;

import com.aipainter.authenticationservice.persistence.entities.AuthenticatedUser;
import com.aipainter.authenticationservice.persistence.entities.RegisteredUser;
import com.aipainter.authenticationservice.persistence.repositories.AuthenticatedUserRepository;
import com.aipainter.authenticationservice.persistence.repositories.UserRepository;
import com.aipainter.authenticationservice.utility.JwtGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Authentication Handler is responsible for handling ops after successful or failed OAuth2 logins.
 * extends {@link SavedRequestAwareAuthenticationSuccessHandler} to redirect to original requested
 * url post login
 *
 * @author srijan.srivastav.personal@gmail.com
 */
@AllArgsConstructor
@Component
public class AuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  @Autowired private final UserRepository userRepository;
  @Autowired private final AuthenticatedUserRepository authenticatedUserRepository;

  /**
   * Called post successful login from {@link SecurityFilterChainConfig} This method is used to
   * attach a cookie with a custom JWT and store relevant information
   */
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws ServletException, IOException {
    OidcUser user = (OidcUser) authentication.getPrincipal();
    // Add cookie before calling super
    response.addCookie(createJwtCookie(user));
    super.onAuthenticationSuccess(request, response, authentication);
    userRepository.save(prepareRegisteredUserEntity(user));
    authenticatedUserRepository.save(prepareAuthenticatedUserEntity(user));
  }

  private RegisteredUser prepareRegisteredUserEntity(OidcUser user) {
    return new RegisteredUser(user.getEmail(), user.getFullName(), user.getPicture());
  }

  private AuthenticatedUser prepareAuthenticatedUserEntity(OidcUser user) {
    return new AuthenticatedUser(
        user.getEmail(),
        Instant.now().plusSeconds(24 * 60 * 60),
        Instant.now());
  }

  /** Called post failed login from {@link SecurityFilterChainConfig} */
  public void onAuthenticationFailure(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException exception) {}

  /**
   * Creates a secure HttpOnly cookie to protect from client side javascript
   *
   * @param user Stores authentication context of the logged-in user
   * @return Custom JWT cookie
   */
  private Cookie createJwtCookie(OidcUser user) {
    Cookie jwtCookie = new Cookie("JWT", JwtGenerator.createJwt(user));
    jwtCookie.setHttpOnly(true);
    jwtCookie.setPath("/");
    return jwtCookie;
  }
}
