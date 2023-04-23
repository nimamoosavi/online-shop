package com.charisma.sales.catalog.web;

import com.charisma.sales.catalog.product.Product;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@RequiredArgsConstructor
@JsonAutoDetect(fieldVisibility = ANY)
@Getter
public final class CatalogDTO {
    private final Product product;
}
