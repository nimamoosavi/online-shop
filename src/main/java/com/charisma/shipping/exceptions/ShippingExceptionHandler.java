package com.charisma.shipping.exceptions;

import com.charisma.common.exception.ExceptionHandler;
import org.springframework.context.support.MessageSourceAccessor;

public class ShippingExceptionHandler extends ExceptionHandler {
    public ShippingExceptionHandler(MessageSourceAccessor messageSourceAccessor) {
        super(messageSourceAccessor);
    }
}
