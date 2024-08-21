package com.lym.project.service.admin;

import com.lym.project.dto.admin.MemberManagementDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberManagementService {
    Page<MemberManagementDTO> paging(Pageable pageable);
}
