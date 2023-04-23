package com.charisma.sales.catalog.web;


public final class CatalogUrlMapping {

    private CatalogUrlMapping(){
        throw new IllegalStateException("Utility class");
    }

    private static final String VERSION_ONE = "/api/v1";


    // Catalog Apis
    private static final String CATALOG = VERSION_ONE +"/catalog";

    public static final String CATALOGS = CATALOG;
}
