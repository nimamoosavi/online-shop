package com.charisma.warehouse.packing;

import com.charisma.warehouse.packing.enums.PackingType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
public class Item {
    @NotNull
    private final Long productId;
    @NotNull
    private final Integer quantity;
    @NotNull
    private final PackingType packingType;
}
