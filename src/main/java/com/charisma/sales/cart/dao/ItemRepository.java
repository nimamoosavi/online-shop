package com.charisma.sales.cart.dao;

import com.charisma.sales.cart.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {

    Optional<Item> findByProductIdAndCartId(Long productId,Long cartId);

    List<Item> findAllByCartId(Long cartId);
}
