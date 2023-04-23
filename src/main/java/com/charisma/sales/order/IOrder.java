package com.charisma.sales.order;

import com.charisma.sales.order.listeners.OrderPaymentStatusEvent;
import com.charisma.sales.order.listeners.PackEvent;
import com.charisma.sales.order.valueobjects.OrderRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author nima
 * @version 1.0.1
 * @implNote this class used for handling User orders
 * @since 1.0.1
 */
public interface IOrder {

    /**
     *
     * @param request is teh users order object
     * @param userId the user id
     * @return the reference that the user can track their order
     */
    String order(@Valid OrderRequest request, long userId);

    Order findByOrderAndUser(long orderId,long userId);

    Order findByTrackingCode(@NotBlank @NotNull String trackingCode);

    void finalizeOrderPayment(@NotBlank @NotNull OrderPaymentStatusEvent request);

    void finalizeOrderPacking(@NotBlank @NotNull PackEvent request);
}
