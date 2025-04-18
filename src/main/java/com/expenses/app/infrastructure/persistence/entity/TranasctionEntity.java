package com.expenses.app.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.expenses.app.domain.enums.TransactionTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TranasctionEntity {
    private UUID id;
    private String description;
    private Double amount;
    private UUID userId;
    private UUID categoryId;
    private TransactionTypeEnum transactionType;
    private LocalDateTime date;
}
