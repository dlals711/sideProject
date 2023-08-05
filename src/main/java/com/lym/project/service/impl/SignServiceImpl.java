package com.lym.project.service.impl;

import com.lym.project.entity.Member;
import com.lym.project.entity.enums.MemberGrade;
import com.lym.project.entity.enums.MemberRole;
import com.lym.project.exception.ApiException;
import com.lym.project.exception.ExceptionEnum;
import com.lym.project.form.sign.JoinForm;
import com.lym.project.repository.SignRepository;
import com.lym.project.service.SignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignServiceImpl implements SignService {
    private final SignRepository signRepository;

    private final PasswordEncoder passwordEncoder;

    public void join(JoinForm form) {
        if (signRepository.existsByEmail(form.getEmail())) {
            throw new ApiException(ExceptionEnum.USER_EMAIL_DUPLICATE);
        }

        Member member = Member.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .phoneNumber(form.getPhoneNumber())
                .grade(MemberGrade.THIRD)
                .role(MemberRole.USER)
                .build();

        signRepository.save(member);
    }
}
