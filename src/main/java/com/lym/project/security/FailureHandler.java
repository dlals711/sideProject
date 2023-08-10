package com.lym.project.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import java.io.IOException;

@Component
public class FailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("FailureHandler");
        final FlashMap flashMap = new FlashMap();

        if (exception instanceof BadCredentialsException) {
            flashMap.put("error", "아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해주세요.");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            flashMap.put("error", "내부 시스템 문제로 로그인 요청을 처리할 수 없습니다. 관리자에게 문의해주세요. ");
        } else if (exception instanceof UsernameNotFoundException) {
            flashMap.put("error", "존재하지 않는 계정입니다. 로그인 계정 정보를 확인해주세요");
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            flashMap.put("error", "인증 요청이 거부되었습니다. 관리자에게 문의해주세요.");
        } else {
            if (exception.getMessage() == null || exception.getMessage().isEmpty())
                flashMap.put("error", "알 수 없는 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            else {
                flashMap.put("error", "내부 서버 오류 : " +  exception.getMessage());
            }
        }

        final FlashMapManager flashMapManager = new SessionFlashMapManager();
        flashMapManager.saveOutputFlashMap(flashMap, request, response);

        response.sendRedirect("/sign/login");
    }
}
