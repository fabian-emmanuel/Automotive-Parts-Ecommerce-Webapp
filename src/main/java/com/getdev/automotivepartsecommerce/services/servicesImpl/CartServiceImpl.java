package com.getdev.automotivepartsecommerce.services.servicesImpl;

import com.getdev.automotivepartsecommerce.models.Cart;
import com.getdev.automotivepartsecommerce.repositories.CartRepo;
import com.getdev.automotivepartsecommerce.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;

    @Override
    public void save(Cart cart) {
        cartRepo.save(cart);
    }
}
