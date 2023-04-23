package com.charisma.payment.payment;

import com.charisma.payment.payment.enums.PaymentStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class Payment {

    private final String referenceNumber;

    private final String reserveNumber;

    private final String trackingCode;

    private final PaymentStatus status;

}
