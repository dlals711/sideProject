package com.lym.project.controller.admin;

import com.lym.project.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
public class ManagementController {
    @GetMapping("/management")
    public ModelAndView home(@AuthenticationPrincipal Member memberInfo) {
        log.info("code page");
        log.info("memberInfo : " + memberInfo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("memberInfo", memberInfo);
        modelAndView.setViewName("admin/management");

        return modelAndView;
    }
}
