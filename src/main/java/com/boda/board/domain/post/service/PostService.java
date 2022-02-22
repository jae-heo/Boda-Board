//package com.boda.board.domain.post.service;
//
//import com.boda.board.domain.post.dto.PostSaveRequestDto;
//import com.boda.board.domain.post.repository.PostRepository;
//import com.boda.board.post.dto.PostSaveRequestDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@RequiredArgsConstructor
//@Service
//public class PostService {
//    private final PostRepository postRepository;
//
//    @Transactional
//    public Long save(PostSaveRequestDto requestDto) {
//        return postRepository.save(requestDto.toEntity()).getId();
//    }
//}
