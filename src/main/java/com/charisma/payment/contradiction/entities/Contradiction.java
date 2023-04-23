package com.charisma.payment.contradiction.entities;

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
public final class Contradiction implements Serializable {

    /**
     * The autoincrement identifier.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /**
     * Indicates the service which this contradiction occurred inside them.
     */
    private String serviceName;

    /**
     * Indicates the reference to follow up the request state.
     */
    private String reference;

    /**
     * Indicates the request-id of the contradiction refund-transfer.
     * <p>
     * <Strong>Note</Strong>:When refunding a transaction it possibly gets an unknown state
     * which must be checked this in the next cycle.
     */
    private String refundRequestId;

    /**
     * The amount of the transaction.
     */
    private BigDecimal amount;

    /**
     * The source account number of the transaction.
     */
    private String sourceAccount;

    /**
     * The destination account number of the transaction.
     */
    private String destinationAccount;

    /**
     * Indicates the retry count, if you set this to 0, the task just is executed one time.
     */
    private int retryCount = 0;


    /**
     * The extra contradiction detail you want to store.
     */
    @Lob
    private String detail;

    /**
     * Indicates the record creation date time.
     */
    private final LocalDateTime createdAt = LocalDateTime.now();

    /**
     * Indicates the record creation date time.
     */
    private LocalDateTime updatedAt;

    /**
     * Used to optimistic locking.
     */
    @Version
    private Integer version;

    @Transient
    private String log;

    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
