package com.charisma.sales.catalog;

import java.util.List;

/**
 * @author nima
 * @version 1.0.1
 * @implNote this class used for handling the Catalog
 * @since 1.0.1
 */
public interface ICatalog {

    Catalog findCatalogByProduct(int productId);

    /**
     *
     * @return all catalogs that we have in our data storage
     */
    List<Catalog> getAllCatalogs();

}
