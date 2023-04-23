package com.charisma.shipping.listeners;

import com.charisma.common.event.Event;
import com.charisma.common.event.EventListener;

public interface DispatchListener<E extends Event> extends EventListener<E> {
}
