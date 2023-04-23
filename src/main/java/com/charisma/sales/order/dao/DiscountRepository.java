package com.charisma.sales.order.dao;

import com.charisma.sales.order.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {

    Optional<Discount> findByCode(String code);
}
