package com.lym.project.service.sign.impl;

import com.lym.project.entity.Member;
import com.lym.project.exception.ApiException;
import com.lym.project.exception.ExceptionEnum;
import com.lym.project.form.sign.LoginForm;
import com.lym.project.repository.sign.LoginRepository;
import com.lym.project.service.sign.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public void login(LoginForm form) {
        Member member = loginRepository.findByEmail(form.getEmail());

        if (member == null || !passwordEncoder.matches(form.getPassword(), member.getPassword())) {
            throw new ApiException(ExceptionEnum.USER_INCORRECT_CREDENTIALS);
        }
    }
}

