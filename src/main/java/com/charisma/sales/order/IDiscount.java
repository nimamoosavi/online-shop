package com.charisma.sales.order;

import com.charisma.sales.order.valueobjects.Discount;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface IDiscount {

    Discount findByCode(@NotBlank @NotNull String code);

    void use(@NotBlank @NotNull String code);
}
