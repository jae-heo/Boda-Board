package com.boda.board.domain.user.domain;

import com.boda.board.domain.post.domain.Post;
import com.boda.board.domain.user.dto.UserRequestDto;
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
public class User extends BaseTimeEntity {

    public enum Type {
        USER, ADMIN
    }

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    @Builder
    public User(String username, String email, String password, Type type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public void updateUser(UserRequestDto userSignUpDto){
        this.username = userSignUpDto.getUsername();
        this.email = userSignUpDto.getEmail();
        this.password = userSignUpDto.getPassword();
        this.type = userSignUpDto.getType();
    }
}
