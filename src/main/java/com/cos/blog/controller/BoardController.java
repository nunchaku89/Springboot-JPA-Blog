package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) { // 컨트롤러에서 세션을 어떻게 찾는지?
        model.addAttribute("boardList", boardService.boardList(pageable));
        return "index";
    }

    // USER 권한 필요
    @GetMapping("/board/insertForm")
    public String insertForm() {
        return "/board/insertForm";
    }

    /**
     * 글 상세 페이지
     * @param id
     * @param model
     * @return String
     */
    @GetMapping("/board/{id}")
    public String findBoardById(@PathVariable int id, Model model, @AuthenticationPrincipal PrincipalDetail principal) {
        model.addAttribute("principal", principal);
        model.addAttribute("detail", boardService.boardDetail(id));
        return "/board/detail";
    }

    @GetMapping("/board/update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("detail", boardService.boardDetail(id));
        return "/board/updateForm";
    }
}
