package com.boda.board.global.error;

import com.boda.board.global.error.dto.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> RuntimeExceptionHandle(RuntimeException exception) {
        return ResponseEntity.badRequest().body(ExceptionResponse.create(exception.getMessage()));
    }
}
