package com.expenses.app.application.usecases.transaction;

import com.expenses.app.application.gateways.TransactionGateway;
import com.expenses.app.domain.entity.Transaction;

public class CreateTransactionInteractor {
    private final TransactionGateway transactionGateway;

    public CreateTransactionInteractor(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    public Transaction execute(Transaction transaction) {
        return transactionGateway.createTransaction(transaction);
    }
}
