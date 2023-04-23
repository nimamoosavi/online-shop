package com.charisma.shipping.entities;

import com.charisma.shipping.enums.DispatchingStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Getter
@Setter
public class Dispatch implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DispatchingStatus status = DispatchingStatus.READY_FOR_DISPATCHING;

    private String address;

    private String trackingCode;

    private String dispatchReference = UUID.randomUUID().toString();
}
