package com.boda.board.domain.board.controller;

import com.boda.board.domain.board.dto.BoardResponseDto;
import com.boda.board.domain.board.dto.BoardResponseMessage;
import com.boda.board.domain.board.dto.CreateBoardRequestDto;
import com.boda.board.domain.board.service.BoardService;
import com.boda.board.global.dto.ResponseDto;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
@Api(tags = {"Board API"})
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<BoardResponseDto>>> findAll() {
        return ResponseEntity.ok(ResponseDto.create(BoardResponseMessage.Board_SUCCESS.getMessage(), this.boardService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponseDto<String>> createBoard(@RequestBody @NonNull CreateBoardRequestDto requestDto) {
        boardService.createBoard(requestDto);
        return ResponseEntity.ok(ResponseDto.create("생성완료"));
    }

}
