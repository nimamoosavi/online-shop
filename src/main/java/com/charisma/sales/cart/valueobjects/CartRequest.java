package com.charisma.sales.cart.valueobjects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CartRequest {

    private final Long productId;

    private final Integer quantity;
}
