package com.boda.board.domain.post.service;

import com.boda.board.domain.post.domain.Post;
import com.boda.board.domain.post.dto.PostSaveRequestDto;
import com.boda.board.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(PostSaveRequestDto requestDto) {
        postRepository.save(Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .build());
    }
}
