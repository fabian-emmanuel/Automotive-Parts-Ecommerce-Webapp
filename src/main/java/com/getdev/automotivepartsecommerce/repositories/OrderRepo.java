package com.getdev.automotivepartsecommerce.repositories;

import com.getdev.automotivepartsecommerce.models.Order;
import com.getdev.automotivepartsecommerce.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUser(UserEntity user);
}
