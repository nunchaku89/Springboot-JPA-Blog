package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDTO;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    /**
     * 회원가입 실행
     * @param user
     * @return ResponseDTO<Integer>
     */
    @PostMapping("/auth/joinProc")
    public ResponseDTO<Integer> join(@RequestBody User user) {
        userService.join(user);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/user")
    public ResponseDTO<Integer> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }

}
