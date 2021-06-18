package com.getdev.automotivepartsecommerce.services.servicesImpl;

import com.getdev.automotivepartsecommerce.models.Product;
import com.getdev.automotivepartsecommerce.repositories.ProductRepo;
import com.getdev.automotivepartsecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public Optional<Product> findById(Long productId) {
        return productRepo.findById(productId);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }
}
