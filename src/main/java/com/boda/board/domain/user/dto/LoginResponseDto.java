package com.boda.board.domain.user.dto;

import com.boda.board.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginResponseDto {

    private String email;
    private String password;
    private String username;
    private User.Type type;

    public LoginResponseDto(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.type = user.getType();
    }
}
