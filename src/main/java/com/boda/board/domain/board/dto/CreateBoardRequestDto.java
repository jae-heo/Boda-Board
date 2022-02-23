package com.boda.board.domain.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBoardRequestDto {
    private String title;

    @Builder
    public CreateBoardRequestDto(String title) {
        this.title = title;
    }
}
