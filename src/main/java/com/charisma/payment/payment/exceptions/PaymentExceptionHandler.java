package com.charisma.payment.payment.exceptions;

import com.charisma.common.exception.ExceptionHandler;
import org.springframework.context.support.MessageSourceAccessor;

public class PaymentExceptionHandler extends ExceptionHandler {
    public PaymentExceptionHandler(MessageSourceAccessor messageSourceAccessor) {
        super(messageSourceAccessor);
    }
}
