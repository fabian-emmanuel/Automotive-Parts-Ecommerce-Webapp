package com.getdev.automotivepartsecommerce.services;

import com.getdev.automotivepartsecommerce.models.Order;
import com.getdev.automotivepartsecommerce.models.UserEntity;

import java.util.List;

public interface OrderService {
    void save(Order order);

    List<Order> findByUser(UserEntity user);
}
