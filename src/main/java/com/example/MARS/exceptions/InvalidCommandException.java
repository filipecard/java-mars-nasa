package com.example.MARS.exceptions;
import org.springframework.web.bind.annotation.ControllerAdvice;
@ControllerAdvice
public class InvalidCommandException extends RuntimeException{
}
