package com.getdev.automotivepartsecommerce.controllers;

import com.getdev.automotivepartsecommerce.services.CartService;
import com.getdev.automotivepartsecommerce.services.ProductService;
import com.getdev.automotivepartsecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final UserService userService;
    private final CartService cartService;
    private final ProductService productService;

//    @PostMapping("/addToCart")
//    public String addProductToCart(){
//
//    }

}
