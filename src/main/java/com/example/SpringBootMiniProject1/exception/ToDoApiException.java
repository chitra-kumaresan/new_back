package com.example.SpringBootMiniProject1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ToDoApiException extends  RuntimeException{
    private HttpStatus status;
    private  String message;

}