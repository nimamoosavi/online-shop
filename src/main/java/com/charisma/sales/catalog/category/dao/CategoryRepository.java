package com.charisma.sales.catalog.category.dao;

import com.charisma.sales.catalog.category.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
