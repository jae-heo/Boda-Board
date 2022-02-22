package com.boda.board.domain.user.dto;

import com.boda.board.domain.user.domain.User;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private String email;
    private String password;
    private String username;
    private User.Grade grade;
}
