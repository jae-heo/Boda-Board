package com.boda.board.domain.post.service;

import com.boda.board.domain.board.domain.Board;
import com.boda.board.domain.board.repository.BoardRepository;
import com.boda.board.domain.post.domain.Post;
import com.boda.board.domain.post.dto.PostResponseDto;
import com.boda.board.domain.post.dto.PostRequestDto;
import com.boda.board.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public void createPost(PostRequestDto requestDto) {
        Board board = boardRepository.findById(requestDto.getBoardId()).orElseThrow(() -> new RuntimeException("없는 보드입니다."));

        Post post = postRepository.save(Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .build());

        post.attachToBoard(board);
    }

    @Transactional
    public List<PostResponseDto> findByBoardId(Integer boardId) {
        if (boardId != null)
            return postRepository.findByBoardId(boardId)
                    .stream()
                    .map(PostResponseDto::new)
                    .collect(Collectors.toList());
        else
            return postRepository.findAll()
                    .stream()
                    .map(PostResponseDto::new)
                    .collect(Collectors.toList());
    }

    @Transactional
    public PostResponseDto findById(Integer postId) {
        return new PostResponseDto(postRepository.findById(postId).orElseThrow(() -> new RuntimeException("없는 게시글입니다.")));
    }

    @Transactional
    public void updateById(Integer postId, PostRequestDto requestDto) {
        postRepository.findById(postId).orElseThrow(() -> new RuntimeException("없는 게시글입니다.")).update(requestDto);
    }

    @Transactional
    public void deleteById(Integer postId) {
        try {
            postRepository.deleteById(postId);
        }catch (IllegalArgumentException e){
            throw new RuntimeException("없는 게시글입니다.");
        }
    }
}
