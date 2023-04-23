package com.charisma.sales.cart.entities;

import com.charisma.user.entities.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.NONE;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "USER_ID",insertable = false,updatable = false)
    @Setter(NONE)
    private User user;

    @Column(name = "user")
    private Long userId;

}
