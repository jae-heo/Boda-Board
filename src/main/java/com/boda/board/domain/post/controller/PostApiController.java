//package com.boda.board.domain.post.controller;
//
//import com.boda.board.domain.post.dto.PostSaveRequestDto;
//import com.boda.board.domain.post.service.PostService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class PostApiController {
//
//    private final PostService postService;
//
//    @PostMapping("post")
//    public Long save(@RequestBody PostSaveRequestDto requestDto) {
//        return postService.save(requestDto);
//    }
//}
