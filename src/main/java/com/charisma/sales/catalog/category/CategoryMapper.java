package com.charisma.sales.catalog.category;

import com.charisma.common.mapper.Mapper;
import com.charisma.sales.catalog.category.entities.Category;
import com.charisma.sales.catalog.category.valueobjects.Title;
import com.charisma.sales.catalog.category.valueobjects.CategoryDto;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
@Component
public abstract class CategoryMapper extends Mapper<Category, Title> {

    @Mapping(target="title", source = "title.name")
    public abstract Category mapTitleToCategory(Title title);

    public abstract Title mapTotitle(CategoryDto request);

    public abstract List<CategoryDto> mapToCategoryDto(List<Title> titles);

}
