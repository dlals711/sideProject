package com.lym.project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/LeeMart")
public class SignController {

    @GetMapping("/login")
    @ResponseBody
    public ModelAndView login() {
        log.info("login page");

        ModelAndView view = new ModelAndView();
        view.setViewName("sign/login");

        return view;
    }

    @GetMapping("/join")
    @ResponseBody
    public ModelAndView join() {
        log.info("join page");

        ModelAndView view = new ModelAndView();
        view.setViewName("sign/join");

        return view;
    }
}
