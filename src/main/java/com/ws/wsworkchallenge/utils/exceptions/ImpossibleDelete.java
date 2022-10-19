package com.ws.wsworkchallenge.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ImpossibleDelete extends RuntimeException {
    public ImpossibleDelete(String message) {
        super(message);
    }
}
