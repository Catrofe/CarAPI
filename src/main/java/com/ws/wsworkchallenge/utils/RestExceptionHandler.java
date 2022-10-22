package com.ws.wsworkchallenge.utils;

import com.ws.wsworkchallenge.utils.exceptions.ExceptionDetails;
import com.ws.wsworkchallenge.utils.exceptions.NotFoundException;
import com.ws.wsworkchallenge.utils.exceptions.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleBrandNotFound(NotFoundException exception) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionDetails> handleImpossibleDelete(ConflictException exception) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .message(exception.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build(), HttpStatus.CONFLICT);
    }
}
