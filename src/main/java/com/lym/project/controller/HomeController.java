package com.lym.project.controller;

import com.lym.project.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public ModelAndView home(@AuthenticationPrincipal Member memberInfo) {
        log.info("home page");
        log.info("memberInfo : " + memberInfo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("memberInfo", memberInfo);
        modelAndView.setViewName("main");

        return modelAndView;
    }
}
