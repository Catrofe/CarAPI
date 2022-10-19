package com.ws.wsworkchallenge.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class SQLException extends RuntimeException{
    public SQLException(String message) {
        super(message);
    }
}
