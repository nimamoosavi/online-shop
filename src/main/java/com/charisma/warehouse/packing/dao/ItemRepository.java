package com.charisma.warehouse.packing.dao;

import com.charisma.warehouse.packing.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
