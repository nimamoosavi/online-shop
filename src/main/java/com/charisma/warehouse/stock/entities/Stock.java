package com.charisma.warehouse.stock.entities;

import com.charisma.warehouse.packing.enums.PackingType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Getter
@Setter
public final class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private Long productId;

    @Enumerated(EnumType.STRING)
    private PackingType packingType;

    private Long quantity;

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt = LocalDateTime.now();

    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}
