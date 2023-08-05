package com.lym.project.form.sign;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinForm {
    @NotBlank(message = "이메일을 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{6,12}",
            message = "비밀번호는 영문자와 숫자, 특수기호가 적어도 1개 이상 포함된 6자~20자의 비밀번호여야 합니다.")
    private String password;
    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    private String passwordCheck;
    @NotBlank(message = "이름을 입력해주세요")
    @Size(min = 2, max = 8, message = "이름을 2~8자 사이로 입력해주세요.")
    private String name;
    @NotBlank(message = "전화번호를 입력해주세요")
    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$",
            message = "10 ~ 11 자리의 숫자만 입력 가능합니다.")
    private String phoneNumber;
}
