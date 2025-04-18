package com.expenses.app.presentation.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.app.application.usecases.transaction.CreateTransactionInteractor;
import com.expenses.app.application.usecases.transaction.GetTransactionInteractor;
import com.expenses.app.application.usecases.transaction.UpdateTransactionInteractor;
import com.expenses.app.domain.entity.Transaction;
import com.expenses.app.infrastructure.mappers.TransactionMapper;
import com.expenses.app.presentation.rest.dto.TransactionRequestDTO;
import com.expenses.app.presentation.rest.dto.TransactionResponseDTO;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final CreateTransactionInteractor createTransactionUseCase;
    private final GetTransactionInteractor getTransactionUseCase;
    private final UpdateTransactionInteractor updateTransactionUseCase;
    private final TransactionMapper transactionMapper;

    public TransactionController(CreateTransactionInteractor createTransactionUseCase, GetTransactionInteractor getTransactionUseCase, UpdateTransactionInteractor updateTransactionUseCase, TransactionMapper transactionMapper) {
        this.createTransactionUseCase = createTransactionUseCase;
        this.getTransactionUseCase = getTransactionUseCase;
        this.updateTransactionUseCase = updateTransactionUseCase; 
        this.transactionMapper = transactionMapper;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO request) {
        Transaction transaction = transactionMapper.mapToTransaction(request);
        Transaction createdTransaction = createTransactionUseCase.execute(transaction);
        return ResponseEntity.ok(transactionMapper.mapTransactionResponseDTO(createdTransaction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getCategory(@PathVariable UUID id) {
        Transaction transaction = getTransactionUseCase.execute(id);
        return ResponseEntity.ok(transactionMapper.mapTransactionResponseDTO(transaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> updateCategory(@PathVariable UUID id, @RequestBody TransactionRequestDTO request) {
        Transaction transaction = updateTransactionUseCase.execute(id, transactionMapper.mapToTransaction(request));
        return ResponseEntity.ok(transactionMapper.mapTransactionResponseDTO(transaction));
    }
}
