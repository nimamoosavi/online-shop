package com.charisma.sales.order.listeners;

import com.charisma.sales.order.IOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component("order-payment-listener")
@RequiredArgsConstructor
public class SimpleEventPaymentListener implements OrderListeners<OrderPaymentStatusEvent> {

    private final IOrder orderService;

    @Override
    @TransactionalEventListener
    @Async
    public void consume(OrderPaymentStatusEvent paymentStatusEvent) {
        orderService.finalizeOrderPayment(paymentStatusEvent);
    }
}
