package com.expenses.app.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.expenses.app.domain.entity.Transaction;
import com.expenses.app.infrastructure.persistence.entity.TranasctionEntity;
import com.expenses.app.presentation.rest.dto.TransactionRequestDTO;
import com.expenses.app.presentation.rest.dto.TransactionResponseDTO;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TranasctionEntity mapToTransactionEntity(Transaction transaction);

    Transaction mapToDomain(TranasctionEntity tranasctionEntity);

    TransactionResponseDTO mapTransactionResponseDTO(Transaction transaction);

    @Mapping(target = "id", ignore = true)
    Transaction mapToTransaction(TransactionRequestDTO transactionRequestDTO);
}
