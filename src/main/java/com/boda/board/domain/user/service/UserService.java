package com.boda.board.domain.user.service;

import com.boda.board.domain.user.dto.SignUpRequestDto;
import com.boda.board.domain.user.dto.SignUpResponseDto;
import com.boda.board.domain.user.repository.UserRepository;
import com.boda.board.domain.user.domain.User;
import com.boda.board.domain.user.dto.LoginRequestDto;
import com.boda.board.domain.user.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public SignUpResponseDto signUp(SignUpRequestDto dto){
        return new SignUpResponseDto(userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .grade(dto.getGrade())
                .build()));
    }

    /**
     * 인증 방식 개선 필요.
     * exception 도 새로 정의해야하고.
     * 일단은 테스트 용도니까 대충 만들도록 하자....
     */
    @Transactional
    public LoginResponseDto login(LoginRequestDto dto) {
        User user = this.findByEmail(dto.getEmail());
        if(user.getPassword().equals(dto.getPassword())){
            return new LoginResponseDto(user);
        }else
            throw new RuntimeException("비밀번호가 틀림");
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("없는 아이디임"));
    }
}
