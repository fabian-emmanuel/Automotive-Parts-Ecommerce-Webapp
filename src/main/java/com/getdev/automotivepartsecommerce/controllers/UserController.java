package com.getdev.automotivepartsecommerce.controllers;

import com.getdev.automotivepartsecommerce.dtos.UserDto;
import com.getdev.automotivepartsecommerce.models.Cart;
import com.getdev.automotivepartsecommerce.models.payloads.requests.UserDetails;
import com.getdev.automotivepartsecommerce.models.payloads.response.UserResponse;
import com.getdev.automotivepartsecommerce.services.CartService;
import com.getdev.automotivepartsecommerce.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserDetails userDetails){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Cart cart = new Cart();
        cartService.save(cart);
        UserDto userDto = mapper.map(userDetails, UserDto.class);
        userDto.setCart(cart);

        userService.createUser(userDto);
        UserResponse response = mapper.map(userDto, UserResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
