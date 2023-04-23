package com.charisma.payment.payment.entities;

import com.charisma.payment.payment.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Getter
@Setter
public final class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String trackingCode;

    private String reference = UUID.randomUUID().toString();

    private String reserveNumber;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
