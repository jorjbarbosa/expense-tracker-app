package com.expenses.app.application.usecases.user;


import com.expenses.app.application.gateways.UserGateway;
import com.expenses.app.domain.entity.User;

public class CreateUserInteractor {
    private final UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        return userGateway.createUser(user);
    }
}
