package com.boda.board.domain.post.dto;

import com.boda.board.domain.post.domain.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PostGetResponseDto {

    private Integer id;

    private String title;

    private String content;

    private LocalDateTime created;

    private LocalDateTime lastModified;

    public PostGetResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.created = post.getCreatedDate();
        this.lastModified = post.getModifiedDate();
    }
}
