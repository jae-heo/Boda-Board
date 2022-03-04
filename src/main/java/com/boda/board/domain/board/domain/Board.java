package com.boda.board.domain.board.domain;


import com.boda.board.domain.post.domain.Post;
import com.boda.board.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>();

    @Builder
    public Board(String title) {
        this.title = title;
    }
}
