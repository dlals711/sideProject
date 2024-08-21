package com.lym.project.repository.admin;

import com.lym.project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberManagementRepository extends JpaRepository<Member, Long> {

}
