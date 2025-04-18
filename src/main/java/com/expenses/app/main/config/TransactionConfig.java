package com.expenses.app.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.expenses.app.application.gateways.TransactionGateway;
import com.expenses.app.application.usecases.transaction.CreateTransactionInteractor;
import com.expenses.app.application.usecases.transaction.GetTransactionInteractor;
import com.expenses.app.application.usecases.transaction.UpdateTransactionInteractor;
import com.expenses.app.infrastructure.gateways.TransactionGatewayImpl;
import com.expenses.app.infrastructure.mappers.TransactionMapper;
import com.expenses.app.infrastructure.persistence.repository.TransactionRepository;

@Configuration
public class TransactionConfig {
    @Bean
    TransactionGateway transactionGateway(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        return new TransactionGatewayImpl(transactionRepository, transactionMapper);
    }

    @Bean
    CreateTransactionInteractor createTransactionUseCase(TransactionGateway transactionGateway) {
        return new CreateTransactionInteractor(transactionGateway);
    }

    @Bean
    GetTransactionInteractor getTransactionUseCase(TransactionGateway transactionGateway) {
        return new GetTransactionInteractor(transactionGateway);
    }

    @Bean
    UpdateTransactionInteractor updateTransactionUseCase(TransactionGateway transactionGateway) {
        return new UpdateTransactionInteractor(transactionGateway);
    }
}
