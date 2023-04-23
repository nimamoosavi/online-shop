package com.charisma.payment.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleEventService implements IEvent<PaymentEvent> {
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(PaymentEvent event) {
        publisher.publishEvent(event);
    }
}
