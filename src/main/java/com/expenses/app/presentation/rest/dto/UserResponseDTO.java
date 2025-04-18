package com.expenses.app.presentation.rest.dto;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email) {

}
