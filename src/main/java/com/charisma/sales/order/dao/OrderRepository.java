package com.charisma.sales.order.dao;

import com.charisma.sales.order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Optional<Order> findByTrackingCode(@NotBlank String trackingCode);

    Optional<Order> findOrderByIdAndUserId(long orderId,long userId);
}
