package com.getdev.automotivepartsecommerce.services.servicesImpl;

import com.getdev.automotivepartsecommerce.dtos.UserDto;
import com.getdev.automotivepartsecommerce.models.UserEntity;
import com.getdev.automotivepartsecommerce.repositories.UserRepo;
import com.getdev.automotivepartsecommerce.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity user = mapper.map(userDto, UserEntity.class);
        userRepo.save(user);

        mapper.map(user, UserDto.class);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findUserByEmail(username);
        if (user == null) throw new UsernameNotFoundException(username);

        return new User(user.getEmail(), user.getEncryptedPassword(),
                true,
                true,
                true,
                true,
                new ArrayList<>());
    }
}
