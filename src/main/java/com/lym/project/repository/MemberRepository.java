package com.lym.project.repository;

import com.lym.project.entity.Member2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member2, Long> {
    Optional<Member2> findByEmail(String email);
}
