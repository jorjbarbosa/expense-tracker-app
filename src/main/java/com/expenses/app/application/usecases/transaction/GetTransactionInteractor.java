package com.expenses.app.application.usecases.transaction;

import java.util.UUID;


import com.expenses.app.application.gateways.TransactionGateway;
import com.expenses.app.domain.entity.Transaction;

public class GetTransactionInteractor {
    private final TransactionGateway transactionGateway;

    public GetTransactionInteractor(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
   
    }

    public Transaction execute(UUID id) {
        return transactionGateway.getTransactionById(id); 
    }
}
