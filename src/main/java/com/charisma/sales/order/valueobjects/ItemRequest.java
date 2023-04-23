package com.charisma.sales.order.valueobjects;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
public class ItemRequest {

    @NotNull
    private final Long productId;
    @NotNull
    private final Integer quantity;
}
