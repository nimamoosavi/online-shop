package com.charisma.warehouse.packing.events;

import com.charisma.common.event.Event;
import com.charisma.warehouse.packing.PackReference;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public final class PackEvent implements Event {

    public final LocalDateTime when;

    @NotBlank
    public final String trackingCode;

    @NotBlank
    public final PackReference packReference;
}
