package com.aipainter.authenticationservice.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
  @GetMapping("v1/home")
  public String homePage() {
    return "<!DOCTYPE html>\n"
        + "<html lang=\"en\">\n"
        + "<head>\n"
        + "    <meta charset=\"UTF-8\">\n"
        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
        + "    <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap\" rel=\"stylesheet\">\n"
        + "    <title>AI Painter</title>\n"
        + "    <style>\n"
        + "        body {\n"
        + "            font-family: 'Poppins', sans-serif;\n"
        + "            margin: 0;\n"
        + "            padding: 0;\n"
        + "            background: linear-gradient(45deg, #4facfe, #00f2fe);\n"
        + "            color: #333;\n"
        + "        }\n"
        + "\n"
        + "        header {\n"
        + "            background-color: rgba(255, 255, 255, 0.9);\n"
        + "            color: #333;\n"
        + "            text-align: center;\n"
        + "            padding: 1em;\n"
        + "            border-bottom: 2px solid #eee;\n"
        + "        }\n"
        + "\n"
        + "        main {\n"
        + "            max-width: 800px;\n"
        + "            margin: 20px auto;\n"
        + "            padding: 20px;\n"
        + "            background-color: rgba(255, 255, 255, 0.95);\n"
        + "            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);\n"
        + "            border-radius: 10px;\n"
        + "        }\n"
        + "\n"
        + "        h1 {\n"
        + "            color: #007bff;\n"
        + "        }\n"
        + "\n"
        + "        p {\n"
        + "            line-height: 1.6;\n"
        + "            color: #555;\n"
        + "        }\n"
        + "    </style>\n"
        + "</head>\n"
        + "<body>\n"
        + "\n"
        + "    <header>\n"
        + "        <h1>AI Painter</h1>\n"
        + "    </header>\n"
        + "\n"
        + "    <main>\n"
        + "        <p>Welcome to AI Painter! Immerse yourself in the enchanting world of digital art created by cutting-edge artificial intelligence.</p>\n"
        + "        <p>Unleash your creativity and explore the endless possibilities with our AI-powered painting tools.</p>\n"
        + "        <!-- Add more content as needed -->\n"
        + "    </main>\n"
        + "\n"
        + "</body>\n"
        + "</html>\n";
  }

  @GetMapping("v1/user")
  public OidcUserInfo userInfo(@AuthenticationPrincipal OidcUser principal) {
    return principal.getUserInfo();
  }
}
