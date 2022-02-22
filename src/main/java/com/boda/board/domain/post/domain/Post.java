//package com.boda.board.domain.post.domain;
//
//import com.boda.board.global.entity.BaseTimeEntity;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@NoArgsConstructor
//@Entity
//public class Post extends BaseTimeEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(length = 500, nullable = false) //원래 default로 column이 되는데 길이나 종류를 따로 설정해주고 싶을 경우 이 어노테이션으로 사용한다.
//    private String title;
//
//    @Column(columnDefinition = "TEXT", nullable = false)
//    private String content;
//
//    private String author;
//
//    @Builder
//    public Post(String title, String content, String author) {
//        this.title = title;
//        this.content = content;
//        this.author = author;
//    }
//}
