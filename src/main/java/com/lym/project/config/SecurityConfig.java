package com.lym.project.config;

import com.lym.project.security.FailureHandler;
import com.lym.project.security.SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*@Configuration
@RequiredArgsConstructor*/
public class SecurityConfig {
    //private final FailureHandler failureHandler;
    //private final SuccessHandler successHandler;
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.formLogin()
                .loginPage("/sign/login")
                .loginProcessingUrl("/sign/procLogin")
                .usernameParameter("email")
                .passwordParameter("password");
                //.successHandler(successHandler)
                //.failureHandler(failureHandler);

        return http.build();
    }
}
