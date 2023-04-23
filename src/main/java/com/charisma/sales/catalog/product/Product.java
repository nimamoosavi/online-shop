package com.charisma.sales.catalog.product;

import com.charisma.sales.catalog.product.enums.PackingType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    private Long id;

    private String title;

    private BigDecimal price;

    private String description;

    private PackingType packingType;

    private String category;
}
