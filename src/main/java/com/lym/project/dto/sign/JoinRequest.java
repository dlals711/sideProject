package com.lym.project.dto.sign;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JoinRequest {
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    private String passwordCheck;
    @NotBlank(message = "이름을 입력해주세요")
    private String name;
    @NotBlank(message = "전화번호를 입력해주세요")
    private String phoneNumber;
}
