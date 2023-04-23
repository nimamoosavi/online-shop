package com.charisma.sales.order.entities;

import com.charisma.user.entities.User;
import com.charisma.sales.order.enums.OrderPaymentStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.NONE;

@Entity(name = "ORDER_ITEM")
@Getter
@Setter
@RequiredArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private BigDecimal total;

    private Double discount;

    private String trackingCode = UUID.randomUUID().toString();

    @OneToMany(mappedBy = "order", fetch = EAGER)
    private List<Item> items;

    private LocalDateTime createAt;

    private LocalDateTime updatedAt = LocalDateTime.now();

    private String deliveryAddress;

    private String discountCode;

    private OrderPaymentStatus paymentStatus = OrderPaymentStatus.NOT_PAYED;

    @ManyToOne
    @JoinColumn(name = "USER_ID",insertable = false,updatable = false)
    @Setter(NONE)
    private User user;

    @Column(name = "user")
    private Long userId;

    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
