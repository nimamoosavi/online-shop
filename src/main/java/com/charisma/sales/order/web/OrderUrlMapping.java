package com.charisma.sales.order.web;


public final class OrderUrlMapping {

    private OrderUrlMapping(){
        throw new IllegalStateException("Utility class");
    }

    private static final String VERSION_ONE = "/api/v1";

    // Order Apis

    private static final String ORDER = VERSION_ONE + "/order";

    public static final String ADD_ORDER = ORDER;

    public static final String GET_ORDER = ORDER + "/{reference}";
}
