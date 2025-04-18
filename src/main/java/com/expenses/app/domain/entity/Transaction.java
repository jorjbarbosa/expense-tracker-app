package com.expenses.app.domain.entity;

import java.util.UUID;

import com.expenses.app.domain.enums.TransactionTypeEnum;

public record Transaction(UUID id, String description, double amount, UUID categoryId, TransactionTypeEnum type) {
    
}
