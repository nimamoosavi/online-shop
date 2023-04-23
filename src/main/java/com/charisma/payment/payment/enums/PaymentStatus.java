package com.charisma.payment.payment.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {

    REQUESTED,

    PASSED,

    FAILED,

    NOT_KNOWN
}
