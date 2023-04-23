package com.charisma.sales.catalog.category.valueobjects;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
public class Title {

    @NotBlank
    @NotNull
    private final String name;
}
