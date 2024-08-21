package com.lym.project.service.admin;

import com.lym.project.dto.admin.MemberManagementDTO;
import com.lym.project.entity.Member;
import com.lym.project.repository.admin.MemberManagementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MemberManagementServiceImpl implements MemberManagementService {
    private final MemberManagementRepository memberManagementRepository;


    public Page<MemberManagementDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1; // page 위치에 있는 값은 0부터 시작한다.
        int pageLimit = 3; // 한페이지에 보여줄 글 개수

        // 한 페이지당 3개식 글을 보여주고 정렬 기준은 ID기준으로 내림차순
        Page<Member> postsPages = memberManagementRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "email")));

        // 목록 : id, title, content, author
        Page<MemberManagementDTO> memberManagementDTO = postsPages.map(postPage -> new MemberManagementDTO(postPage));

        return memberManagementDTO;
    }
}
