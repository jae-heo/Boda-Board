package com.boda.board.domain.post.controller;

import com.boda.board.domain.post.dto.PostCreateRequestDto;
import com.boda.board.domain.post.service.PostService;
import com.boda.board.global.dto.ResponseDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
@Api(tags = {"Post API"})
public class PostApiController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<ResponseDto> save(@RequestBody PostCreateRequestDto requestDto) {
        postService.createPost(requestDto);
        return ResponseEntity.ok(ResponseDto.create("생성완료"));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> findByBoardId(@RequestParam @Nullable Integer boardId) {
        return ResponseEntity.ok(ResponseDto.create("게시글 목록을 불러왔습니다.", postService.findByBoardId(boardId)));
    }
}
