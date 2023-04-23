package com.charisma.shipping.listeners;

import com.charisma.shipping.IDispatch;
import com.charisma.shipping.valueobject.Dispatch;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component("dispatch-listener")
@RequiredArgsConstructor
public class SimpleEventListener implements DispatchListener<DispatchinEvent> {

    private final IDispatch dispatchService;

    @Override
    @TransactionalEventListener
    @Async
    public void consume(DispatchinEvent dispatchinEvent) {
        var dispatch = new Dispatch(dispatchinEvent.getTrackingCode(),
                dispatchinEvent.getPackReference(),
                dispatchinEvent.getAddress());
        dispatchService.createTask(dispatch);
    }
}
