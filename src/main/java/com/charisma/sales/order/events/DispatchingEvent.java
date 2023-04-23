package com.charisma.sales.order.events;

import com.charisma.common.event.Event;
import com.charisma.warehouse.packing.PackReference;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class DispatchingEvent implements Event {
    public final LocalDateTime when;

    @NotBlank
    public final String trackingCode;

    @NotNull
    public final PackReference packReference;

    @NotBlank
    public final String address;
}
