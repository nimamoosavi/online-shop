package com.charisma.sales.order.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class MinimumAmountRuleException extends RuntimeException{

    public MinimumAmountRuleException(String message) {
        super(message);
    }
}
