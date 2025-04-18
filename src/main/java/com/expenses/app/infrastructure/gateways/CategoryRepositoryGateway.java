package com.expenses.app.infrastructure.gateways;

import java.util.UUID;

import com.expenses.app.application.gateways.CategoryGateway;
import com.expenses.app.domain.entity.Category;
import com.expenses.app.infrastructure.mappers.CategoryMapper;
import com.expenses.app.infrastructure.persistence.entity.CategoryEntity;
import com.expenses.app.infrastructure.persistence.repository.CategoryRepository;

public class CategoryRepositoryGateway implements CategoryGateway {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryRepositoryGateway(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category createCategory(Category category) {
        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryMapper.mapToEntity(category));
        return categoryMapper.mapToDomain(savedCategoryEntity);
    }

    @Override
    public Category getCategoryById(UUID categoryId) {
        CategoryEntity categoryEntity = categoryRepository
            .findById(categoryId)
            .orElse(null);
        
        return categoryMapper.mapToDomain(categoryEntity);
    }

    @Override
    public Category updateCategory(UUID id, Category category) {
        CategoryEntity categoryEntity = categoryRepository
            .findById(id)
            .orElse(null);

        categoryEntity.setName(category.name());

        return categoryMapper.mapToDomain(categoryRepository.save(categoryEntity));
    }
}
