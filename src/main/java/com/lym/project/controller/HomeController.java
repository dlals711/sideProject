package com.lym.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class HomeController {
    @GetMapping("/")
    public ModelAndView login() {
        log.info("home page");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");

        return modelAndView;
    }
}
