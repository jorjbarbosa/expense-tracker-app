package com.expenses.app.application.usecases.user;

import java.util.UUID;

import com.expenses.app.application.gateways.UserGateway;
import com.expenses.app.domain.entity.User;

public class GetUserInteractor {
    private final UserGateway userGateway;

    public GetUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
 
    }
    public User getUserById(UUID userId) {
        return userGateway.getUserById(userId);
    }
}
