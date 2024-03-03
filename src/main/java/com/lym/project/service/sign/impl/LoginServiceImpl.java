package com.lym.project.service.sign.impl;

import com.lym.project.entity.Member;
import com.lym.project.form.sign.LoginForm;
import com.lym.project.repository.sign.LoginRepository;
import com.lym.project.service.sign.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService, UserDetailsService {
    private final LoginRepository loginRepository;
    //private final BCryptPasswordEncoder passwordEncoder;

    public void login(LoginForm form) {
        Member member = loginRepository.findByEmail(form.getEmail());

       /* if (member == null || !passwordEncoder.matches(form.getPassword(), member.getPassword())) {
            throw new ApiException(ExceptionEnum.USER_INCORRECT_CREDENTIALS);
        }*/
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return loginRepository.findByemail(email).orElseThrow(() -> new IllegalArgumentException(email));
    }
}

