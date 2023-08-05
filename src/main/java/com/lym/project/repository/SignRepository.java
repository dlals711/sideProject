package com.lym.project.repository;

import com.lym.project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
}
