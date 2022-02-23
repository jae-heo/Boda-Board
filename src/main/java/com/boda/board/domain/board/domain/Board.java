package com.boda.board.domain.board.domain;


import com.boda.board.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Column(nullable = false)
    private String title;

    @Builder
    public Board(String title) {
        this.title = title;
    }
}
