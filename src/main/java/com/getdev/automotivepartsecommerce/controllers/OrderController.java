package com.getdev.automotivepartsecommerce.controllers;

import com.getdev.automotivepartsecommerce.models.Order;
import com.getdev.automotivepartsecommerce.models.UserEntity;
import com.getdev.automotivepartsecommerce.services.OrderService;
import com.getdev.automotivepartsecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;

    @PostMapping("/{email}")
    public ResponseEntity<Order> submitOrder(@PathVariable String email) {
        UserEntity user = userService.findUserByEmail(email);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        Order order = Order.createFromCart(user.getCart());
        orderService.save(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Order>> getOrdersForUser(@PathVariable String email) {
        UserEntity user = userService.findUserByEmail(email);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderService.findByUser(user));
    }
}
