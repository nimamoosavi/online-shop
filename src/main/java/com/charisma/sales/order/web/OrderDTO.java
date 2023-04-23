package com.charisma.sales.order.web;

import com.charisma.sales.order.valueobjects.Item;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@RequiredArgsConstructor
@JsonAutoDetect(fieldVisibility = ANY)
public final class OrderDTO  implements Serializable {

    private final List<Item> items;

    private final BigDecimal total;

    private final Double discount;
}
