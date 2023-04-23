package com.charisma.sales.order;

import com.charisma.sales.order.dao.DiscountRepository;
import com.charisma.sales.order.exception.DiscountNotFoundException;
import com.charisma.sales.order.valueobjects.Discount;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
public class SimpleDiscountService implements IDiscount{

    private final DiscountRepository discountRepository;

    private final DiscountMapper discountMapper;

    @Override
    public Discount findByCode(String code) {
        var discount = discountRepository.findByCode(code).orElseThrow(
                () -> new DiscountNotFoundException("Code not found !")
        );
        return discountMapper.toRequestModel(discount);

    }

    @Override
    public void use(@NotNull @NotBlank String code) {
        var discount = discountRepository.findByCode(code).orElseThrow(
                () -> new DiscountNotFoundException("Code not found!")
        );

        if (Boolean.TRUE.equals(discount.isUsed()))
            throw new DiscountNotFoundException("Code not found!");

        discount.setUsed(true);
        discountRepository.save(discount);
    }
}
