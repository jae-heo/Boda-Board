package com.boda.board.domain.user.domain;

import com.boda.board.domain.user.dto.SignUpRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    public enum Grade{
        USER, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Builder
    public User(String username, String email, String password, Grade grade) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.grade = grade;
    }

    public void updateUser(SignUpRequestDto userSignUpDto){
        this.username = userSignUpDto.getUsername();
        this.email = userSignUpDto.getEmail();
        this.password = userSignUpDto.getPassword();
        this.grade = userSignUpDto.getGrade();
    }
}
