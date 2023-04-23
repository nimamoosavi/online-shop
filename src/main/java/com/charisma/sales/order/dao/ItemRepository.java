package com.charisma.sales.order.dao;

import com.charisma.sales.order.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long>{

}
