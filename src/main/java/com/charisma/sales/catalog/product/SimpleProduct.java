package com.charisma.sales.catalog.product;

import com.charisma.sales.catalog.product.dao.ProductRepository;
import com.charisma.sales.catalog.product.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SimpleProduct implements IProduct {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public Product findById(long id) {
        var product = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product Not Found")
        );

        return productMapper.requestToSource(product);
    }

    @Override
    public List<Product> getAll() {
        var products = productRepository.findAll();

        return productMapper.requestToSource(products);
    }
}
