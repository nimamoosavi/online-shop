package com.charisma.warehouse.stock;

import com.charisma.warehouse.packing.enums.PackingType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
public class Stock {

    @NotNull
    private final Long productId;

    @NotNull
    private final PackingType packingType;

    @NotNull
    private final Long quantity;
}
