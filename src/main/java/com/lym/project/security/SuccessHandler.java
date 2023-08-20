package com.lym.project.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("SuccessHandler");
        UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
/*
        if (user.getIsApproval().equals("N")) {
            final FlashMap flashMap = new FlashMap();
            flashMap.put("error", "승인되지 않은 사용자입니다. 관리자에게 문의하세요.");
            final FlashMapManager flashMapManager = new SessionFlashMapManager();
            flashMapManager.saveOutputFlashMap(flashMap, request, response);
            SecurityContextHolder.clearContext();
            response.sendRedirect("/sign/login");
        } else {
            response.sendRedirect("/");
        }*/
        response.sendRedirect("/");
    }
}
