package com.charisma.sales.cart.web;

import com.charisma.sales.cart.valueobjects.Item;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@RequiredArgsConstructor
public final class CartDTO implements Serializable {

    private final List<Item> items;

    private final BigDecimal total;

    private final Double discountPercentage;

    private final Integer tax;
}
