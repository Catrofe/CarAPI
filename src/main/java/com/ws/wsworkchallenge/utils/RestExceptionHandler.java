package com.ws.wsworkchallenge.utils;

import com.ws.wsworkchallenge.utils.exceptions.ItemNotFoudDetails;
import com.ws.wsworkchallenge.utils.exceptions.ItemNotFound;
import com.ws.wsworkchallenge.utils.exceptions.SQLException;
import com.ws.wsworkchallenge.utils.exceptions.SQLExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ItemNotFound.class)
    public ResponseEntity<ItemNotFoudDetails> handleBrandNotFound(ItemNotFound exception) {
        return new ResponseEntity<>(ItemNotFoudDetails.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<SQLExceptionDetails> handleBrandDelete(ItemNotFound exception) {
        return new ResponseEntity<>(SQLExceptionDetails.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build(), HttpStatus.NOT_FOUND);
    }
}
