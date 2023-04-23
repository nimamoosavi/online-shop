package com.charisma.common.event;

public interface EventListener<E extends Event> {

    void consume(E e);
}
