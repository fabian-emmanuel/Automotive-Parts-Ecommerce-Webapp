package com.getdev.automotivepartsecommerce.services;

import com.getdev.automotivepartsecommerce.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void createUser(UserDto userDto);
}
