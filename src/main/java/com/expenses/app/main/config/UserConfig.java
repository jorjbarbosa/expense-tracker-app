package com.expenses.app.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.expenses.app.application.gateways.UserGateway;
import com.expenses.app.application.usecases.user.CreateUserInteractor;
import com.expenses.app.application.usecases.user.GetUserInteractor;
import com.expenses.app.infrastructure.gateways.UserRepositoryGateway;
import com.expenses.app.infrastructure.mappers.UserMapper;
import com.expenses.app.infrastructure.persistence.repository.UserRepository;

@Configuration
public class UserConfig {

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserMapper userMapper) {
        return new UserRepositoryGateway(userRepository, userMapper);
    }
    
    @Bean
    CreateUserInteractor createUserUseCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    GetUserInteractor getUserUseCase(UserGateway userGateway) {
        return new GetUserInteractor(userGateway);
    }
}
