package com.lym.project.controller.sign;

import com.lym.project.service.sign.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/sign")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "exception", required = false) String exception,
                              Model model) {
        log.info("login page");

        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "sign/login";
    }

    @PostMapping("/processLogin")
    public String login() {
        System.out.println("h2");

        return "/";
    }

    /*@PostMapping("/login")
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
    }*/
}
