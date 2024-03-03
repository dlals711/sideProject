package com.lym.project.repository.sign;

import com.lym.project.entity.Member;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByemail(String email);

    Member findByEmail(String email);
}
