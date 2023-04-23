package com.charisma.sales.cart.exception;

import com.charisma.common.exception.ExceptionHandler;
import org.springframework.context.support.MessageSourceAccessor;

public class CartExceptionHandler extends ExceptionHandler {
    public CartExceptionHandler(MessageSourceAccessor messageSourceAccessor) {
        super(messageSourceAccessor);
    }
}
