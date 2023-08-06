package com.lym.project.repository.sign;

import com.lym.project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
}
