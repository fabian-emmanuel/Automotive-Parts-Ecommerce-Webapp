package com.getdev.automotivepartsecommerce.services;

import com.getdev.automotivepartsecommerce.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long productId);

    List<Product> findAllProducts();

    List<Product> findByName(String name);

}
