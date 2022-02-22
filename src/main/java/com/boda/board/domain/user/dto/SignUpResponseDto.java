package com.boda.board.domain.user.dto;

import com.boda.board.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto {
    private String email;

    public SignUpResponseDto(User user) {
        this.email = user.getEmail();
    }
}
