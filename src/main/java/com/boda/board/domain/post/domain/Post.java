package com.boda.board.domain.post.domain;

import com.boda.board.domain.board.domain.Board;
import com.boda.board.domain.user.domain.User;
import com.boda.board.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "user_id")
    private Integer authorId;

    @Column(name = "board_id")
    private Integer boardId;

    @Setter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User author;

    @Setter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", insertable = false, updatable = false)
    private Board board;

    @Builder
    public Post(String title, String content, Integer authorId, Integer boardId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.boardId = boardId;
    }
}
