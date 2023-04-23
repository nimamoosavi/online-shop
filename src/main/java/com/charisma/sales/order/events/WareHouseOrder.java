package com.charisma.sales.order.events;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WareHouseOrder {

    private final Integer productId;

    private final Integer quantity;
}
