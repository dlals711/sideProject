package com.lym.project.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
    // System Exception
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003"),

    // User Exception
    SECURITY(HttpStatus.UNAUTHORIZED, "UE0001", "로그인이 필요합니다"),
    USER_PASSWORD_NOT_EQUAL(HttpStatus.BAD_REQUEST, "UE0001", "비밀번호가 일치하지 않습니다"),
    USER_EMAIL_DUPLICATE(HttpStatus.CONFLICT, "UE0002", "이미 가입된 이메일입니다"),
    USER_INCORRECT_CREDENTIALS(HttpStatus.UNAUTHORIZED, "UE0003", "이메일 또는 비밀번호가 올바르지 않습니다");

    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
