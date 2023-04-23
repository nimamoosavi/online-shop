package com.charisma.sales.order.events;

import com.charisma.common.event.Event;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class WareHouseEvent implements Event {

    public final LocalDateTime when;

    @NotBlank
    public final String trackingCode;

    @NotEmpty
    public final List<WareHouseOrder> items;
}
