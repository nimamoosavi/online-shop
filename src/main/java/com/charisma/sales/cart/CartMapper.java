package com.charisma.sales.cart;


import com.charisma.common.mapper.Mapper;
import com.charisma.sales.cart.web.CartDTO;
import org.springframework.stereotype.Component;

@Component
@org.mapstruct.Mapper
public abstract class CartMapper extends Mapper<Cart, com.charisma.sales.cart.entities.Cart> {

    public abstract CartDTO mapToCartDTO(Cart cart);

}
