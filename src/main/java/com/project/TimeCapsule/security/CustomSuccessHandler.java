package com.project.TimeCapsule.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        
        var authorities = authentication.getAuthorities();
        var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();

        switch (roles.orElse("")) {
        case "ADMIN":
            System.out.println("User has ADMIN role. Redirecting to /admin-page");
            response.sendRedirect("/admin-page");
            break;
        case "USER":
            System.out.println("User has USER role. Redirecting to /home");
            response.sendRedirect("/home");
            break;
        default:
            System.out.println("Unknown role. Redirecting to /error");
            response.sendRedirect("/error");
            break;
    }
    }

}