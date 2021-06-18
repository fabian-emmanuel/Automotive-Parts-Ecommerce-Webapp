package com.getdev.automotivepartsecommerce.repositories;

import com.getdev.automotivepartsecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
