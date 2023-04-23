package com.charisma.sales.order.events;

import com.charisma.common.event.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class SimpleEventService implements IEvent<Event>{

    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(Event event) {
        publisher.publishEvent(event);
    }
}
