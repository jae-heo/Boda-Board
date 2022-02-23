package com.boda.board.domain.post.service;

import com.boda.board.domain.board.domain.Board;
import com.boda.board.domain.board.repository.BoardRepository;
import com.boda.board.domain.post.domain.Post;
import com.boda.board.domain.post.dto.PostGetResponseDto;
import com.boda.board.domain.post.dto.PostCreateRequestDto;
import com.boda.board.domain.post.repository.PostRepository;
import com.boda.board.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class PostService {

    private final BoardRepository boardRepository;
    private final PostRepository postRepository;

    @Transactional
    public void createPost(PostCreateRequestDto requestDto) {
        Board board = boardRepository.findById(requestDto.getBoardId()).orElseThrow(() -> new RuntimeException("없는 보드입니다."));

        Post post = postRepository.save(Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .build());

        post.attachToBoard(board);
    }

    @Transactional
    public List<PostGetResponseDto> findByBoardId(Integer boardId) {
        if (boardId != null)
            return postRepository.findByBoardId(boardId)
                    .stream()
                    .map(PostGetResponseDto::new)
                    .collect(Collectors.toList());
        else
            return postRepository.findAll()
                    .stream()
                    .map(PostGetResponseDto::new)
                    .collect(Collectors.toList());
    }
}
