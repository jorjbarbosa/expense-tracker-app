package com.expenses.app.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.expenses.app.domain.entity.Category;
import com.expenses.app.infrastructure.persistence.entity.CategoryEntity;
import com.expenses.app.presentation.rest.dto.CategoryRequestDTO;
import com.expenses.app.presentation.rest.dto.CategoryResponseDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity mapToEntity(Category category);

    Category mapToDomain(CategoryEntity categoryEntity);

    CategoryResponseDTO mapToCategoryResponseDTO(Category category);

    @Mapping(target = "id", ignore = true)
    Category mapToCategory(CategoryRequestDTO categoryRequestDTO);
}
