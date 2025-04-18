package com.expenses.app.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.expenses.app.domain.enums.TransactionTypeEnum;

public record Transaction(
    UUID id,
    String description,
    Double amount,
    UUID categoryId,
    UUID userId,
    TransactionTypeEnum type,
    LocalDateTime date
) {}
