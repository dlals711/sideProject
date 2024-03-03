package com.lym.project.entity;

import com.lym.project.entity.enums.MemberGrade;
import com.lym.project.entity.enums.MemberRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(length = 50)
    private String email;
    @Column(length = 100)
    private String password;
    @Column(name = "phone_number",length = 11)
    private String phoneNumber;
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

    @Builder
    public Member(String email, String password, String name, String phoneNumber, MemberRole role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
