package com.ws.wsworkchallenge.utils;

import com.ws.wsworkchallenge.utils.exceptions.GenericException;
import com.ws.wsworkchallenge.utils.exceptions.GenericExceptionDetails;
import com.ws.wsworkchallenge.utils.exceptions.ImpossibleDelete;
import com.ws.wsworkchallenge.utils.exceptions.ImpossibleDeleteDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericExceptionDetails> handleBrandNotFound(GenericException exception) {
        return new ResponseEntity<>(GenericExceptionDetails.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ImpossibleDelete.class)
    public ResponseEntity<ImpossibleDeleteDetails> handleImpossibleDelete(ImpossibleDelete exception) {
        return new ResponseEntity<>(ImpossibleDeleteDetails.builder()
                .message(exception.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build(), HttpStatus.CONFLICT);
    }
}
