package com.charisma.sales.catalog.product.entities;

import com.charisma.sales.catalog.category.entities.Category;
import com.charisma.sales.catalog.product.enums.PackingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.NONE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public final class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;

    private BigDecimal price;

    private String description;

    @Enumerated(EnumType.STRING)
    private PackingType packingType;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID",insertable = false,updatable = false)
    @Setter(NONE)
    private Category category;

    @Column(name = "category")
    private Long categoryId;

}
