package com.charisma.shipping.listeners;

import com.charisma.common.event.Event;
import com.charisma.warehouse.packing.PackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class DispatchinEvent implements Event {

    private final LocalDateTime when;

    private final String trackingCode;

    @NotNull
    public final PackReference packReference;

    @NotBlank
    public final String address;
}
