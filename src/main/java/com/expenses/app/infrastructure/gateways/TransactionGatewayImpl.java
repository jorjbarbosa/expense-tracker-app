package com.expenses.app.infrastructure.gateways;

import java.util.UUID;

import com.expenses.app.application.gateways.TransactionGateway;
import com.expenses.app.domain.entity.Transaction;
import com.expenses.app.infrastructure.mappers.TransactionMapper;
import com.expenses.app.infrastructure.persistence.entity.TranasctionEntity;
import com.expenses.app.infrastructure.persistence.repository.TransactionRepository;

public class TransactionGatewayImpl implements TransactionGateway  {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionGatewayImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        TranasctionEntity tranasctionEntity = transactionMapper.mapToTransactionEntity(transaction);
        TranasctionEntity savedTranasctionEntity = transactionRepository.save(tranasctionEntity);
        return transactionMapper.mapToDomain(savedTranasctionEntity);
    }

    @Override
    public Transaction getTransactionById(UUID id) {
        TranasctionEntity tranasctionEntity = transactionRepository.findById(id).orElse(null);
        return transactionMapper.mapToDomain(tranasctionEntity);
    }

    @Override
    public Transaction updateTransaction(UUID id, Transaction transaction) {
        TranasctionEntity tranasctionEntity = transactionRepository.findById(id).orElse(null);
        return transactionMapper.mapToDomain(tranasctionEntity);
        // TO-DO implement this method
    }


}
