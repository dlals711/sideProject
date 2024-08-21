package com.lym.project.dto.admin;

import com.lym.project.entity.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberManagementDTO {
    private String email;
    private String name;
    private String grade;
    private LocalDateTime regDate;
    private String role;
    private String phoneNumber;

    public MemberManagementDTO(Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
        this.grade = member.getGrade().toString();
        this.regDate = member.getRegDate();
        this.role = member.getRole().toString();
        this.phoneNumber = member.getPhoneNumber();
    }
}
