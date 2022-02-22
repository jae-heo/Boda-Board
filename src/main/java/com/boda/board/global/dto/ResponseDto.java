package com.boda.board.global.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto <T>{
    private String message;
    private T data;

    public static <T> ResponseDto<T> create(String message){
        return new ResponseDto<>(message, null);
    }

    public static <T> ResponseDto<T> create(String message, T dto){
        return new ResponseDto<>(message, dto);
    }


}
