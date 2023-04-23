package com.charisma.warehouse.packing.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.NONE;

@Entity(name = "PACK_ITEM")
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private Long productId;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "PACK_ID",insertable = false,updatable = false)
    @Setter(NONE)
    private Pack pack;

    @Column(name = "pack")
    private Long packId;
}
