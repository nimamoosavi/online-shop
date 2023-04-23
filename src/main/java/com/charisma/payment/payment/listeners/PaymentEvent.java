package com.charisma.payment.payment.listeners;

import com.charisma.common.event.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class PaymentEvent implements Event {

    private final LocalDateTime when;

    private final String trackingCode;
}
