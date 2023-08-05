package com.lym.project.controller;

import com.lym.project.form.sign.JoinForm;
import com.lym.project.service.SignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/LeeMart")
public class SignController {
    private final SignService signService;

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

    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity<?> join(@RequestBody @Validated JoinForm form,
                                  BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errorMap);
        }

        if (!form.getPassword().equals(form.getPasswordCheck())) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("passwordCheck", "비밀번호가 일치하지 않습니다");

            return ResponseEntity.badRequest().body(errorMap);
        }

        signService.join(form);
        return null;
    }
}
