package com.boda.board.domain.post.controller;

import com.boda.board.domain.post.dto.PostRequestDto;
import com.boda.board.domain.post.dto.PostResponseDto;
import com.boda.board.domain.post.service.PostService;
import com.boda.board.global.dto.ResponseDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
@Api(tags = {"Post API"})
public class PostApiController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<ResponseDto> createPost(@RequestBody PostRequestDto requestDto) {
        postService.createPost(requestDto);
        return ResponseEntity.ok(ResponseDto.create("생성완료"));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<PostResponseDto>>> findByBoardId(@RequestParam @Nullable Integer boardId) {
        return ResponseEntity.ok(ResponseDto.create("게시글 목록을 불러왔습니다.", postService.findByBoardId(boardId)));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable @Nullable Integer postId){
        postService.deleteById(postId);
        return ResponseEntity.ok(ResponseDto.create("삭제 되었습니다."));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponseDto<PostResponseDto>> findById(@PathVariable @Nullable Integer postId) {
        return ResponseEntity.ok(ResponseDto.create("게시글을 불러왔습니다.", postService.findById(postId)));
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<ResponseDto> updateById(@PathVariable @Nullable Integer postId, @RequestBody PostRequestDto requestDto){
        postService.updateById(postId, requestDto);
        return ResponseEntity.ok(ResponseDto.create("게시글을 수정했습니다."));
    }
}
