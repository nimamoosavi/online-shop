package com.charisma.shipping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DispatchingCodeNotFoundException extends RuntimeException{
    public DispatchingCodeNotFoundException(String message) {
        super(message);
    }
}
