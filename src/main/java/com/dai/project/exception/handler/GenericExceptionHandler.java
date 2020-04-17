package com.dai.project.exception.handler;

import com.dai.project.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler({ DataNotFoundException.class })
    public ResponseEntity<String> handleDataNotFoundException() {
        return new ResponseEntity<String>("Data not found exception!",HttpStatus.NO_CONTENT);
    }
}
