package com.charisma.warehouse.stock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ProductNotQuantityException extends RuntimeException{
    public ProductNotQuantityException(String message) {
        super(message);
    }
}
