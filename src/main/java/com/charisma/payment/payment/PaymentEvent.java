package com.charisma.payment.payment;

import com.charisma.common.event.Event;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public final class PaymentEvent implements Event {

    public final LocalDateTime when;

    @NotBlank
    public final String trackingCode;
}
