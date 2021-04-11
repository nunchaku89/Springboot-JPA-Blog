package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /**
     * 회원가입 페이지
     * @return String
     */
    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    /**
     * 로그인 페이지
     * @return String
     */
    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm(@AuthenticationPrincipal PrincipalDetail principal, Model model) {
        model.addAttribute("principal", principal);
        return "/user/updateForm";
    }

}
