package com.expenses.app.application.gateways;

import java.util.UUID;

import com.expenses.app.domain.entity.User;

public interface UserGateway {
    User createUser(User user);
    User getUserById(UUID userId);
}
