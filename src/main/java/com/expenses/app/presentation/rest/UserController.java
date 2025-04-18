package com.expenses.app.presentation.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.app.application.usecases.user.CreateUserInteractor;
import com.expenses.app.application.usecases.user.GetUserInteractor;
import com.expenses.app.domain.entity.User;
import com.expenses.app.infrastructure.mappers.UserMapper;
import com.expenses.app.presentation.rest.dto.UserRequestDTO;
import com.expenses.app.presentation.rest.dto.UserResponseDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final CreateUserInteractor createUserUseCase;
    private final GetUserInteractor getUserUseCase;

    private final UserMapper userMapper;

    public UserController(CreateUserInteractor createUserUseCase, GetUserInteractor getUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
        User userBusinessObject = userMapper.mapToUser(request);
        User createdUser = createUserUseCase.createUser(userBusinessObject);
        return ResponseEntity.ok(userMapper.mapToResponseDTO(createdUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getMethodName(@PathVariable UUID id) {
        return ResponseEntity.ok(userMapper.mapToResponseDTO(getUserUseCase.getUserById(id)));
    }
}
