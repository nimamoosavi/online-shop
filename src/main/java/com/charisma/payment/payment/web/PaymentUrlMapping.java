package com.charisma.payment.payment.web;


public final class PaymentUrlMapping {

    private PaymentUrlMapping(){
        throw new IllegalStateException("Utility class");
    }

    private static final String VERSION_ONE = "/api/v1";

    // CARTS API
    private static final String PAYMENT = VERSION_ONE +"/payment";

    public static final String PAY = PAYMENT + "/{reference}";
}
