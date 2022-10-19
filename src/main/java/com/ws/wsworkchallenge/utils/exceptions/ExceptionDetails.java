package com.ws.wsworkchallenge.utils.exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ExceptionDetails {
    protected String message;
    protected int status;
}
