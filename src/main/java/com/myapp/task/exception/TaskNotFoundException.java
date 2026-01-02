package com.myapp.task.exception;

/*@ResponseStatus(HttpStatus.NOT_FOUND)*/
public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String message){
        super(message);
    }
}
