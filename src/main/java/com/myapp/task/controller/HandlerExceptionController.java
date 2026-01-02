package com.myapp.task.controller;

import com.myapp.task.exception.TaskNotFoundException;
import com.myapp.task.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Error> taskNotFound(Exception ex){
        Error error = new Error();
        error.setDate(LocalDateTime.now());
        error.setError("Tarea no válida!");
        error.setDescription(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);

    }
}
