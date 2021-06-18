package com.getdev.automotivepartsecommerce.repositories;

import com.getdev.automotivepartsecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
