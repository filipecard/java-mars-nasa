package com.example.MARS.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomException {

    @ExceptionHandler({InvalidCommandException.class})
    public ResponseEntity<String> BadRequestHandler(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad Request");
    }

}