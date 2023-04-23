package com.charisma.payment.payment.dao;

import com.charisma.payment.payment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Optional<Payment> findByTrackingCode(String trackingCode);

    Optional<Payment> findByReference(String reference);
}
