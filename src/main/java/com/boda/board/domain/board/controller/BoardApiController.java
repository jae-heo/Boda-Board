package com.boda.board.domain.board.controller;

import com.boda.board.domain.board.dto.BoardResponseDto;
import com.boda.board.domain.board.dto.BoardResponseMessage;
import com.boda.board.domain.board.service.BoardService;
import com.boda.board.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<BoardResponseDto>>> findAll() {
        return ResponseEntity.ok(ResponseDto.create(BoardResponseMessage.Board_SUCCESS.getMessage(), this.boardService.findAll()));
    }

}
