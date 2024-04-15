package com.lym.project.controller;

import com.lym.project.dto.JwtToken;
import com.lym.project.dto.MemberDto;
import com.lym.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    // 회원가입 API
    @PostMapping("/join")
    public Long join(@RequestBody MemberDto memberDto) {
        return memberService.join(memberDto);
    }

    // 로그인 API
    @PostMapping("/sign-in")
    public JwtToken login(@RequestBody MemberDto memberDto) {
        System.out.println("memberDto : " +memberDto);
        String username = memberDto.getEmail();
        String password = memberDto.getPassword();
        return memberService.signIn(username, password);
    }

    @GetMapping("/sign-in")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView();
        view.setViewName("member/login");
        return view;
    }

    @GetMapping("/view")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ModelAndView view(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("view");
        System.out.println("view222");
        System.out.println("getUsername : " + userDetails.getUsername());
        System.out.println("getPassword : " + userDetails.getPassword());
        System.out.println("getAuthorities : " + userDetails.getAuthorities());

        ModelAndView view = new ModelAndView();
        view.setViewName("member/test");
        //view.setViewName("redirect:/member/test"); // 리다이렉트할 URL 설정
        return view;
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAnyRole('USER')")
    public String test2(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("getUsername : " + userDetails.getUsername());
        System.out.println("getPassword : " + userDetails.getPassword());
        System.out.println("getAuthorities : " + userDetails.getAuthorities());
        return "success";
    }
}