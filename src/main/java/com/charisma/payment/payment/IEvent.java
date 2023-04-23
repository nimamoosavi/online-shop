package com.charisma.payment.payment;

import com.charisma.common.event.Event;
import com.charisma.common.event.EventBus;

public interface IEvent<E extends Event> extends EventBus<E> {
}
