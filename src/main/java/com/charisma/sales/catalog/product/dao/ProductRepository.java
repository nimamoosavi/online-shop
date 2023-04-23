package com.charisma.sales.catalog.product.dao;

import com.charisma.sales.catalog.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
