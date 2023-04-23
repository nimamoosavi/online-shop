package com.charisma.sales.catalog;

import com.charisma.sales.catalog.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class Catalog {

    private final Product product;
}
