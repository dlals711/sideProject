package com.lym.project.service.sign.impl;

import com.lym.project.entity.Member;
import com.lym.project.exception.ApiException;
import com.lym.project.exception.ExceptionEnum;
import com.lym.project.form.sign.LoginForm;
import com.lym.project.repository.sign.LoginRepository;
import com.lym.project.security.UserSecurityEntity;
import com.lym.project.service.sign.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService, UserDetailsService {
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("user service loadUserByUsername");
        System.out.println("email : " + email);

        Member member = loginRepository.findByEmail(email);
        if (member == null) {
            System.out.println("sout 존재하지 않는 유저입니다");
            throw new IllegalArgumentException("존재하지 않는 유저입니다");
        }

        return UserSecurityEntity.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .authority(Collections.singletonList("USER"))
                .build();
    }

    public void login(LoginForm form) {
        Member member = loginRepository.findByEmail(form.getEmail());

        if (member == null || !passwordEncoder.matches(form.getPassword(), member.getPassword())) {
            throw new ApiException(ExceptionEnum.USER_INCORRECT_CREDENTIALS);
        }
    }
}

