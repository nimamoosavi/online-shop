package com.charisma.sales.order.listeners;

import com.charisma.sales.order.IOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component("order-pack-listener")
@RequiredArgsConstructor
public class SimpleEventPackListener implements OrderListeners<PackEvent> {

    private final IOrder orderService;

    @Override
    @TransactionalEventListener
    @Async
    public void consume(PackEvent packEvent) {
        orderService.finalizeOrderPacking(packEvent);
    }
}
