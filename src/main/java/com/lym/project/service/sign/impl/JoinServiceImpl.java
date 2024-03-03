package com.lym.project.service.sign.impl;

import com.lym.project.entity.Member;
import com.lym.project.entity.enums.MemberGrade;
import com.lym.project.entity.enums.MemberRole;
import com.lym.project.exception.ApiException;
import com.lym.project.exception.ExceptionEnum;
import com.lym.project.form.sign.JoinForm;
import com.lym.project.repository.sign.JoinRepository;
import com.lym.project.service.sign.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class JoinServiceImpl implements JoinService {
    private final JoinRepository joinRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public void join(JoinForm form) {
        if (joinRepository.existsByEmail(form.getEmail())) {
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

        joinRepository.save(member);
    }
}
