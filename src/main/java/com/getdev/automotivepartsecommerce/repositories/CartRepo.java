package com.getdev.automotivepartsecommerce.repositories;

import com.getdev.automotivepartsecommerce.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}
