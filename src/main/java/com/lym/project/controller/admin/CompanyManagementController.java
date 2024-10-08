package com.lym.project.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
public class CompanyManagementController {

    @GetMapping("/companyManagement")
    public String content2(Model model) {
        model.addAttribute("content3", "This is content 2");
        return "admin/companyManagement :: contentFragment3";
    }
}
