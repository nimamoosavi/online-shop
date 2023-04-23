package com.charisma.payment.payment.listeners;

import com.charisma.payment.payment.IPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component("payment-listener")
@RequiredArgsConstructor
public class SimpleEventListener implements PaymentListeners<PaymentEvent>{

    private final IPayment payment;

    @Override
    @TransactionalEventListener
    @Async
    public void consume(PaymentEvent paymentEvent) {
        payment.create(paymentEvent.getTrackingCode());
    }
}
