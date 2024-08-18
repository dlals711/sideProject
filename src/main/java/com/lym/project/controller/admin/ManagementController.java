package com.lym.project.controller.admin;

import com.lym.project.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/content2")
    public String content1(Model model) {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        model.addAttribute("items", items);
        model.addAttribute("content2", "This is content 1");
        return "admin/content :: contentFragment2";
    }

    @GetMapping("/content3")
    public String content2(Model model) {
        model.addAttribute("content3", "This is content 2");
        return "admin/content :: contentFragment3";
    }
}
