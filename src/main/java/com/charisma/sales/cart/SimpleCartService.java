package com.charisma.sales.cart;

import com.charisma.sales.cart.exception.CartNotFoundException;
import com.charisma.sales.cart.dao.CartRepository;
import com.charisma.sales.cart.valueobjects.CartRequest;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class SimpleCartService implements ICart {

    private final CartRepository cartRepository;

    private final IItem itemService;

    private static final String CART_NOT_FOUND = "Cart Not Found";

    @Override
    @Transactional
    public void add(CartRequest request,long userId) {

        var cart = cartRepository.findByUserId(userId).orElseThrow(
                () -> new CartNotFoundException(CART_NOT_FOUND)
        );

        itemService.add(request.getProductId(), cart.getId(),request.getQuantity());
    }


    @Override
    public void empty(long userId) {
        var cart = cartRepository.findByUserId(userId).orElseThrow(
                () -> new CartNotFoundException(CART_NOT_FOUND)
        );

        itemService.removeAll(cart.getId());
    }

    @Override
    public Cart carts(long userId) {
        var cart = cartRepository.findByUserId(userId).orElseThrow(
                () -> new CartNotFoundException(CART_NOT_FOUND)
        );
        var items = itemService.getAllItems(cart.getId());
        return Cart.builder().items(items).build();
    }


}
