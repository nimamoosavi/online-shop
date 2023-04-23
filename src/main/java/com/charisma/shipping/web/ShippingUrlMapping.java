package com.charisma.shipping.web;


public final class ShippingUrlMapping {

    private ShippingUrlMapping(){
        throw new IllegalStateException("Utility class");
    }

    private static final String VERSION_ONE = "/api/v1";

    // CARTS API
    private static final String SHIPPING = VERSION_ONE +"/shipping";


    public static final String SHIPPING_STATUS = SHIPPING + "/{reference}";
    public static final String CHANGE_SHIPPING_STATUS = SHIPPING + "/{reference}/status/{status}";
}
