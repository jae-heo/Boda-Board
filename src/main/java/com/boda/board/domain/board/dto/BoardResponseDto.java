package com.boda.board.domain.board.dto;

import com.boda.board.domain.board.domain.Board;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponseDto {
    private Integer id;
    private String title;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
    }
}
