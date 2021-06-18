package com.getdev.automotivepartsecommerce.controllers;

import com.getdev.automotivepartsecommerce.models.Cart;
import com.getdev.automotivepartsecommerce.models.Product;
import com.getdev.automotivepartsecommerce.models.UserEntity;
import com.getdev.automotivepartsecommerce.models.payloads.requests.CartRequest;
import com.getdev.automotivepartsecommerce.services.CartService;
import com.getdev.automotivepartsecommerce.services.ProductService;
import com.getdev.automotivepartsecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final UserService userService;
    private final CartService cartService;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Cart> addProductToCart(@RequestBody CartRequest cartRequest){
        UserEntity user = userService.findUserByEmail(cartRequest.getEmail());
        if(user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Optional<Product> product = productService.findById(cartRequest.getProductId());
        if (product.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Cart cart = user.getCart();

        IntStream.range(0, cartRequest.getQuantity()).forEach(i -> cart.addProduct(product.get()));
        cartService.save(cart);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping
    public ResponseEntity<Cart> removeProductFromCart(@RequestBody CartRequest cartRequest){
        UserEntity user = userService.findUserByEmail(cartRequest.getEmail());
        if(user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Optional<Product> product = productService.findById(cartRequest.getProductId());
        if (product.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Cart cart = user.getCart();

        IntStream.range(0, cartRequest.getQuantity()).forEach(i->cart.removeProduct(product.get()));
        cartService.save(cart);
        return ResponseEntity.ok(cart);
    }

}
