package com.boda.board.domain.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private Integer boardId;
}
