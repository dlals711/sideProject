package com.lym.project.service;

import com.lym.project.dto.JwtToken;
import com.lym.project.dto.MemberDto;

public interface MemberService {
    public JwtToken signIn(String username, String password);

    Long join(MemberDto memberDto);
}
