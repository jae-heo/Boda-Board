package com.boda.board.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserResponseMessage {
    SIGN_UP_SUCCESS("회원가입 성공."),
    LOGIN_SUCCESS("로그인 성공.");

    private final String message;
}
