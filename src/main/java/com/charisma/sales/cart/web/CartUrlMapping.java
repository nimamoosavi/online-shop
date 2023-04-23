package com.charisma.sales.cart.web;


public final class CartUrlMapping {

    private CartUrlMapping(){
        throw new IllegalStateException("Utility class");
    }

    private static final String VERSION_ONE = "/api/v1";

    // CARTS API
    private static final String CART = VERSION_ONE +"/cart";

    public static final String CARTS = CART;
    public static final String ADD_CART = CART;

    public static final String REMOVE_CARTS = CART;
}
