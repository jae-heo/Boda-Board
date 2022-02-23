package com.boda.board.domain.board.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoardResponseMessage {
    Board_SUCCESS("게시판 목록 불러오기 성공.");

    private final String message;
}
