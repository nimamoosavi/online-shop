package com.charisma.warehouse.packing.entities;

import com.charisma.warehouse.packing.enums.PackingType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Getter
@Setter
public class Pack implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PackingType packingType;

    private String packReference = UUID.randomUUID().toString();

    private String trackingCode;
}
