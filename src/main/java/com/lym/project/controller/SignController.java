package com.lym.project.controller;

import com.lym.project.dto.sign.JoinRequest;
import com.lym.project.exception.ApiException;
import com.lym.project.exception.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> join(@RequestBody @Validated JoinRequest request,
                                  BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        if (!request.getPassword().equals(request.getPasswordCheck())) {
            throw new ApiException(ExceptionEnum.USER_PASSWORD_NOT_EQUAL);
        }

        System.out.println(request);
        return null;
    }
}
