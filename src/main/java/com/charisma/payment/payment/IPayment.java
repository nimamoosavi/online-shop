package com.charisma.payment.payment;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author nima
 * @version 1.0.1
 * @implNote this class used for Payment Service
 * @since 1.0.1
 */
public interface IPayment {

    /**
     *
     * @param reference is the parameter that generate in Internet payment gateway
     * this api must be implemented with third party IPGs
     */
    void pay(@NotBlank @NotNull String reference);

    /**
     *
     * @param trackingCode is the reference that used for track the order in the whole service
     * @return {#Payment} is the object that can be return for payment
     */
    Payment findByTrackingCode(@NotBlank @NotNull String trackingCode);

    /**
     *
     * @param reference is the reference that used for track the order in the payment service
     * @return {#Payment} is the object that can be return for payment
     */

    Payment findByPaymentReference(@NotBlank @NotNull String reference);

    /**
     *
     * @param reserveNumber is the reference that we can track the payment request
     * @return {#Payment} is the object that can be return for payment
     */
    String create(String reserveNumber);
}
