package com.charisma.sales.catalog.product;

import java.util.List;

public interface IProduct {

    Product findById(long id);

    List<Product> getAll();
}
