package com.charisma.sales.order.valueobjects;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class OrderRequest {

    @NotEmpty
    private final List<ItemRequest> items;

    @NotNull
    @NotBlank
    private final String deliveryAddress;

    private final String discountCode;

}
