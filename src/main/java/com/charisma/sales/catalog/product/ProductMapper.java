package com.charisma.sales.catalog.product;

import com.charisma.common.mapper.Mapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

@org.mapstruct.Mapper
public abstract class ProductMapper extends Mapper<Product, com.charisma.sales.catalog.product.entities.Product> {

    @AfterMapping
    public void mapToTarget(@MappingTarget Product target, com.charisma.sales.catalog.product.entities.Product product) {
        target.setCategory(product.getCategory().getTitle());
    }
}
