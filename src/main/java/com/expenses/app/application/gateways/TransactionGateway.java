package com.expenses.app.application.gateways;

import java.util.UUID;

import com.expenses.app.domain.entity.Transaction;

public interface TransactionGateway {
    Transaction createTransaction(Transaction transaction);
    Transaction getTransactionById(UUID transactionId);
    Transaction updateTransaction(UUID id, Transaction transaction);
}
