package com.charisma.sales.catalog;

import com.charisma.sales.catalog.product.IProduct;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SimpleCatalog implements ICatalog{

    private final IProduct productService;
    @Override
    public Catalog findCatalogByProduct(int productId) {
        var product = productService.findById(productId);
        return new Catalog(product);
    }

    @Override
    public List<Catalog> getAllCatalogs() {
        var products = productService.getAll();
        return products.
                stream()
                .map(Catalog::new)
                .collect(Collectors.toList());
    }
}
