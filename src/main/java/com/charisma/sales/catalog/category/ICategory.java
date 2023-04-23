package com.charisma.sales.catalog.category;

import com.charisma.sales.catalog.category.valueobjects.Title;


import javax.validation.Valid;
import java.util.List;

public interface ICategory {

    void add(@Valid Title title);

    List<Title> getCategories();
}
