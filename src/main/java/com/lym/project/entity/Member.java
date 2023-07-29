package com.lym.project.entity;

import com.lym.project.entity.enums.MemberGrade;
import com.lym.project.entity.enums.MemberRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(length = 50)
    private String email;
    @Column(length = 100)
    private String password;
    @Column(name = "phone_number",length = 11)
    private int phoneNumber;
    @Column(length = 20)
    private String name;
    @Embedded
    Address address;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MemberRole role;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MemberGrade grade;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Basket basket;
}
