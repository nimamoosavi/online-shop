package com.charisma.sales.order.exception;

import com.charisma.common.exception.ExceptionHandler;
import org.springframework.context.support.MessageSourceAccessor;

public class OrderExceptionHandler extends ExceptionHandler {
    public OrderExceptionHandler(MessageSourceAccessor messageSourceAccessor) {
        super(messageSourceAccessor);
    }
}
