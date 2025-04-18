package com.expenses.app.infrastructure.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.app.infrastructure.persistence.entity.TranasctionEntity;

public interface TransactionRepository extends JpaRepository<TranasctionEntity, UUID> {
    
}
