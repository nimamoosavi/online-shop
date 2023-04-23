package com.charisma.warehouse.packing.web;


public final class PackingUrlMapping {

    private PackingUrlMapping(){
        throw new IllegalStateException("Utility class");
    }

    private static final String VERSION_ONE = "/api/v1";

    // PACK API
    private static final String PACKING = VERSION_ONE +"/pack";


    public static final String PACK = PACKING + "/{reference}";

}
