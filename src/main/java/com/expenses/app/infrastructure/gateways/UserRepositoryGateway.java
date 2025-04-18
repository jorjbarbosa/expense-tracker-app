package com.expenses.app.infrastructure.gateways;

import java.util.UUID;

import com.expenses.app.application.gateways.UserGateway;
import com.expenses.app.domain.entity.User;
import com.expenses.app.infrastructure.mappers.UserMapper;
import com.expenses.app.infrastructure.persistence.entity.UserEntity;
import com.expenses.app.infrastructure.persistence.repository.UserRepository;

public class UserRepositoryGateway implements UserGateway  {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
 
    }
    @Override
    public User createUser(User user) {
       UserEntity userEntity = userMapper.mapToEntity(user);
       UserEntity savedUserEntity = userRepository.save(userEntity);
       return userMapper.mapToDomain(savedUserEntity);
    }

    @Override
    public User getUserById(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        return userMapper.mapToDomain(userEntity);
    }
    
}
