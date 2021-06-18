package com.getdev.automotivepartsecommerce.repositories;

import com.getdev.automotivepartsecommerce.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    Optional<Payment> findPaymentByOrderId(int orderId);
}
