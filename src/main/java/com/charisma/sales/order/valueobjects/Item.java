package com.charisma.sales.order.valueobjects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public final class Item implements Serializable {

    private final String title;

    private final BigDecimal price;

    private final String description;

    private final String category;

    private final Integer quantity;
}
