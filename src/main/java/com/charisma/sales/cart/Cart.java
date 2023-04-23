package com.charisma.sales.cart;

import com.charisma.sales.cart.valueobjects.Item;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Builder
public final class Cart implements Serializable {

    private List<Item> items;

    private final BigDecimal total;

    private final Double discountPercentage;

    private final Integer tax;
}