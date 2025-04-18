package com.expenses.app.application.usecases.transaction;

import java.util.UUID;

import com.expenses.app.application.gateways.TransactionGateway;
import com.expenses.app.domain.entity.Transaction;

public class UpdateTransactionInteractor {
    private final TransactionGateway transactionGateway;

    public UpdateTransactionInteractor(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    public Transaction execute(UUID id, Transaction transaction) {
        return transactionGateway.updateTransaction(id, transaction);
    }
}
