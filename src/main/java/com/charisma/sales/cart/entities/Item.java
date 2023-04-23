package com.charisma.sales.cart.entities;

import com.charisma.sales.catalog.product.entities.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.NONE;

@Entity(name = "CART_ITEM")
@Getter
@Setter
@RequiredArgsConstructor
public class Item implements Serializable {

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
    @JoinColumn(name = "CART_ID",insertable = false,updatable = false)
    @Setter(NONE)
    private Cart cart;

    @Column(name = "cart")
    private Long cartId;
}
