package com.charisma.common.event;

public interface EventBus<E extends Event> {

    void publish(E event);
}
