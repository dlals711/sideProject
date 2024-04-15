//package com.lym.project.config;
//
//import com.lym.project.jwt.JwtAuthenticationFilter;
//import com.lym.project.jwt.JwtTokenProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SpringSecurityConfig {
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                // REST API이므로 basic auth 및 csrf 보안을 사용하지 않음
//                .httpBasic().disable()
//                .csrf().disable()
//                // JWT를 사용하기 때문에 세션을 사용하지 않음
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeHttpRequests()
//                // 해당 API에 대해서는 모든 요청을 허가
//                .requestMatchers("/members/sign-in").permitAll()
//                .requestMatchers("/members/join").permitAll()
//                .requestMatchers("/members/view").permitAll()
//                // USER 권한이 있어야 요청할 수 있음
//                //.requestMatchers("/members/test").hasRole("USER")
//                //.requestMatchers("/members/test2").hasRole("ADMIN")
//                // 이 밖에 모든 요청에 대해서 인증을 필요로 한다는 설정
//                .anyRequest().authenticated()
//                .and()
//                // JWT 인증을 위하여 직접 구현한 필터를 UsernamePasswordAuthenticationFilter 전에 실행
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class).build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder encoder() {
//        // BCrypt Encoder 사용
//        return new BCryptPasswordEncoder();
//    }
//
//
//}