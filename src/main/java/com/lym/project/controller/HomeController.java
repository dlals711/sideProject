package com.lym.project.controller;

import com.lym.project.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/content1")
    public String content1(Model model) {
        model.addAttribute("content1", "This is content 1");
        return "content :: contentFragment1";
    }

    @GetMapping("/content2")
    public String content2(Model model) {
        model.addAttribute("content2", "This is content 2");
        return "content :: contentFragment2";
    }

}
