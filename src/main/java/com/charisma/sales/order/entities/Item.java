package com.charisma.sales.order.entities;


import com.charisma.sales.catalog.product.entities.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.NONE;

@Entity(name = "ORDER_ITEM")
@Getter
@Setter
@RequiredArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID",insertable = false,updatable = false)
    @Setter(NONE)
    private Product product;

    @Column(name = "product")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID",insertable = false,updatable = false)
    @Setter(NONE)
    private Order order;

    @Column(name = "order")
    private Long orderId;
}
