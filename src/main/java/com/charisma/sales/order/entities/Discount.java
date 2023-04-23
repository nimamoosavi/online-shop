package com.charisma.sales.order.entities;

import com.charisma.sales.order.enums.DiscountType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Discount implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String code;

    private Integer percentage;

    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private boolean isUsed = false;

    private LocalDateTime createAt;

    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
