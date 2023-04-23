package com.charisma.warehouse.stock.dao;

import com.charisma.warehouse.stock.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findByProductId(@NotNull Long productId);
}
