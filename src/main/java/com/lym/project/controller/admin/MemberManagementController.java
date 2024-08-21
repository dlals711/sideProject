package com.lym.project.controller.admin;

import com.lym.project.dto.admin.MemberManagementDTO;
import com.lym.project.service.admin.MemberManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
public class MemberManagementController {
    private final MemberManagementService memberManagementService;
    @GetMapping("/memberManagement")
    public String content1(Model model) {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        model.addAttribute("items", items);
        model.addAttribute("content2", "This is content 1");
        return "admin/memberManagement :: contentFragment2";
    }

    @GetMapping("/memberManagement/paging")
    public String paging(@PageableDefault(page = 1) Pageable pageable, Model model) {
        Page<MemberManagementDTO> postsPages = memberManagementService.paging(pageable);

        /**
         * blockLimit : page 개수 설정
         * 현재 사용자가 선택한 페이지 앞 뒤로 3페이지씩만 보여준다.
         * ex : 현재 사용자가 4페이지라면 2, 3, (4), 5, 6
         */
        int blockLimit = 3;
        int startPage = (((int) Math.ceil(((double) pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = Math.min((startPage + blockLimit - 1), postsPages.getTotalPages());

        model.addAttribute("postsPages", postsPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "paging";
    }
}
