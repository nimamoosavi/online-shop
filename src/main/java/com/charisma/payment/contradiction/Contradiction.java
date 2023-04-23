package com.charisma.payment.contradiction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class Contradiction {

    private String reference;

    /**
     * Indicates the request-id of the contradiction refund-transfer.
     * <p>
     * <Strong>Note</Strong>:When refunding a transaction it possibly gets an unknown state
     * which must be checked this in the next cycle.
     */
    private String refundRequestId;

    /**
     * The amount of the transaction.
     */
    private BigDecimal amount;


    /**
     * The destination account number of the transaction.
     */
    private String destinationAccount;
}
