package com.expenses.app.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.expenses.app.domain.entity.User;
import com.expenses.app.infrastructure.persistence.entity.UserEntity;
import com.expenses.app.presentation.rest.dto.UserRequestDTO;
import com.expenses.app.presentation.rest.dto.UserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity mapToEntity(User user);
    
    User mapToDomain(UserEntity userEntity);
    
    UserResponseDTO mapToResponseDTO(User user);
    
    @Mapping(target = "id", ignore = true)
    User mapToUser(UserRequestDTO userRequestDTO);
}
