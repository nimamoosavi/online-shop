package com.charisma.sales.cart;

import com.charisma.sales.cart.valueobjects.CartRequest;

/**
 * @author nima
 * @version 1.0.1
 * @implNote this class used for handling User basket
 * @since 1.0.1
 */
public interface ICart{

    /**
     *
     * @param add is an object that customer needed to add
     * @param userId the customer id
     */
    void add(CartRequest add,long userId);

    /**
     * @apiNote remove all user cart
     * @param userId the customer id
     */
    void empty(long userId);

    /**
     *
     * @param userId the customer id
     * @return the user carts
     */
    Cart carts(long userId);

}
