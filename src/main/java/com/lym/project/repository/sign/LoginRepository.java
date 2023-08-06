package com.lym.project.repository.sign;

import com.lym.project.entity.Member;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
