package com.lym.project.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final FailureHandler failureHandler;
    private final SuccessHandler successHandler;
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeHttpRequests()
                .requestMatchers("/**").permitAll()
                .and()
                    .formLogin()
                    .loginPage("/sign/login")
                    .defaultSuccessUrl("/")
/*                    .failureHandler(failureHandler)
                    .successHandler(successHandler)*/
                    .usernameParameter("email")
                    .passwordParameter("password");


                /*.and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/sign/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);*/

        return http.build();
    }
}
