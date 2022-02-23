package com.boda.board.domain.user.controller;

import com.boda.board.domain.user.dto.*;
import com.boda.board.global.dto.ResponseDto;
import com.boda.board.domain.user.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Api(tags = {"User API"})
public class UserApiController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto<SignUpResponseDto>> signUp(@Valid @RequestBody SignUpRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDto.create(UserResponseMessage.SIGN_UP_SUCCESS.getMessage(),this.userService.signUp(requestDto)));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<LoginResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto) {
        return ResponseEntity.ok(ResponseDto.create(UserResponseMessage.LOGIN_SUCCESS.getMessage(), this.userService.login(requestDto)));
    }
}
