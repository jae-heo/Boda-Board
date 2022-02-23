package com.boda.board.domain.post.controller;

import com.boda.board.domain.post.dto.PostSaveRequestDto;
import com.boda.board.domain.post.service.PostService;
import com.boda.board.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("post")
    public ResponseEntity<ResponseDto> save(@RequestBody PostSaveRequestDto requestDto) {
        postService.save(requestDto);
        return ResponseEntity.ok(ResponseDto.create("생성완료"));
    }
}
