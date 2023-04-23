package com.charisma.sales.catalog.category;

import com.charisma.sales.catalog.category.valueobjects.Title;
import com.charisma.sales.catalog.category.dao.CategoryRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SimpleCategory implements ICategory {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public void add(Title title) {
        var category = categoryMapper.mapTitleToCategory(title);
        categoryRepository.save(category);
    }

    @Override
    public List<Title> getCategories() {
        var categories = categoryRepository.findAll();
        return categoryMapper.toRequestModel(categories);
    }
}
