package com.expenses.app.domain.entity;

import java.util.UUID;

public record User(UUID id, String name, String email, String password) {
    
}
