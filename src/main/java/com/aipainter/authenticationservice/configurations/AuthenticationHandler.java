package com.aipainter.authenticationservice.configurations;

import com.aipainter.authenticationservice.utility.JwtGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Authentication Handler is responsible for handling ops after successful or failed OAuth2 logins.
 * extends see {@link SavedRequestAwareAuthenticationSuccessHandler} to redirect to original requested url post login
 *
 * @author srijan.srivastav.personal@gmail.com
 */
@AllArgsConstructor
@Component
public class AuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  private final JwtGenerator jwtGenerator;

  /**
   * Called post successful login from {@link SecurityFilterChainConfig}
   * This method is used to attach a cookie with a custom JWT
   */
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws ServletException, IOException {
    response.addCookie(createJwtCookie(authentication));
    super.onAuthenticationSuccess(request, response, authentication);
  }

  /**
   * Called post failed login from {@link SecurityFilterChainConfig}
   */
  public void onAuthenticationFailure(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException exception) {}

  /**
   * Creates a secure HttpOnly cookie to protect from client side javascript
   *
   * @param authentication Stores authentication context of the logged-in user
   * @return Custom JWT cookie
   */
  private Cookie createJwtCookie(Authentication authentication) {
    Cookie jwtCookie = new Cookie("JWT", jwtGenerator.createJwt(authentication));
    jwtCookie.setHttpOnly(true);
    jwtCookie.setPath("/");
    return jwtCookie;
  }
}
