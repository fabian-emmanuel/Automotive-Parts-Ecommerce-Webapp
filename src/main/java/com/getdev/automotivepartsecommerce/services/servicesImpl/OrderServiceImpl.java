package com.getdev.automotivepartsecommerce.services.servicesImpl;

import com.getdev.automotivepartsecommerce.models.Order;
import com.getdev.automotivepartsecommerce.models.UserEntity;
import com.getdev.automotivepartsecommerce.repositories.OrderRepo;
import com.getdev.automotivepartsecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    @Override
    public void save(Order order) {
        orderRepo.save(order);
    }

    @Override
    public List<Order> findByUser(UserEntity user) {
        return orderRepo.findByUser(user);
    }
}
