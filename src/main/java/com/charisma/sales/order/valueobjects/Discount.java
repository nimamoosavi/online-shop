package com.charisma.sales.order.valueobjects;

import com.charisma.sales.order.enums.DiscountType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class Discount {

    private final DiscountType type;

    private final BigDecimal value;

    private final Integer percentage;

}
