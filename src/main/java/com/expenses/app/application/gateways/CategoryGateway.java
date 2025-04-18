package com.expenses.app.application.gateways;

import java.util.UUID;

import com.expenses.app.domain.entity.Category;

public interface CategoryGateway {
    Category createCategory(Category category);
    Category getCategoryById(UUID categoryId);
    Category updateCategory(UUID id, Category category);
}