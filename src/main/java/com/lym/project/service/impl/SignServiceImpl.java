package com.lym.project.service.impl;

import com.lym.project.form.sign.JoinForm;
import com.lym.project.repository.SignRepository;
import com.lym.project.service.SignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignServiceImpl implements SignService {
    private final SignRepository signRepository;

    public void join(JoinForm form) {

    }
}
