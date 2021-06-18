package com.getdev.automotivepartsecommerce.services;

import com.getdev.automotivepartsecommerce.dtos.UserDto;
import com.getdev.automotivepartsecommerce.models.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void createUser(UserDto userDto);
    UserDto getUserDetailsByEmail(String email);
    UserEntity findUserByEmail(String email);
}
