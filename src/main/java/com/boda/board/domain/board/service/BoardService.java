package com.boda.board.domain.board.service;

import com.boda.board.domain.board.dto.BoardResponseDto;
import com.boda.board.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public List<BoardResponseDto> findAll(){
        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

}
