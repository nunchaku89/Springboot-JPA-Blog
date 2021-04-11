package com.cos.blog.controller.api;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDTO;
import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.service.BoardService;
import com.cos.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDTO<Integer> insertBoard(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
        boardService.insertBoard(board, principal.getUser());
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDTO<Integer> deleteBoardById(@PathVariable int id) {
        boardService.deleteBoardById(id);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/board/{id}")
    public ResponseDTO<Integer> updateBoardById(@PathVariable int id, @RequestBody Board board) {
        boardService.updateBoardById(id, board);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }
}
