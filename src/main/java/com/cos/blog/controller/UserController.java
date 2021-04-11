package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /**
     * 회원가입 페이지
     * @return
     */
    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    /**
     * 로그인 페이지
     * @return
     */
    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

}
