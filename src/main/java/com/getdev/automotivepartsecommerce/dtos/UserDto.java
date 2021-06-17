package com.getdev.automotivepartsecommerce.dtos;

import com.getdev.automotivepartsecommerce.models.Cart;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private Cart cart;
}
