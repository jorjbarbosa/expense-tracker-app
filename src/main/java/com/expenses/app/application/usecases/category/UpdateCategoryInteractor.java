package com.expenses.app.application.usecases.category;

import java.util.UUID;

import com.expenses.app.application.gateways.CategoryGateway;
import com.expenses.app.domain.entity.Category;

public class UpdateCategoryInteractor {
    private CategoryGateway categoryGateway;
    
    public UpdateCategoryInteractor(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public Category execute(UUID id, Category category) {
        return categoryGateway.updateCategory(id, category);
    }
}
