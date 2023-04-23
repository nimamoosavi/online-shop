package com.charisma.sales.order.listeners;

import com.charisma.common.event.Event;
import com.charisma.sales.order.enums.OrderPaymentStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class OrderPackEvent implements Event {

    private final LocalDateTime when;

    private final String trackingCode;

    private final OrderPaymentStatus status;
}
