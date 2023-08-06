package com.lym.project.controller.sign;

import com.lym.project.form.sign.JoinForm;
import com.lym.project.form.sign.LoginForm;
import com.lym.project.service.sign.LoginService;
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
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    @ResponseBody
    public ModelAndView login() {
        log.info("login page");

        ModelAndView view = new ModelAndView();
        view.setViewName("sign/login");

        return view;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> join(@RequestBody @Validated LoginForm form,
                                  BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errorMap);
        }

        loginService.login(form);
        return ResponseEntity.ok().build();
    }
}
