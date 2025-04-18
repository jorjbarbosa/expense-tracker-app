package com.expenses.app.application.usecases.category;

import java.util.UUID;

import com.expenses.app.application.gateways.CategoryGateway;
import com.expenses.app.domain.entity.Category;

public class GetCategoryInteractor {
    private final CategoryGateway categoryGateway;

    public GetCategoryInteractor(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public Category execute(UUID categoryId) {
        return categoryGateway.getCategoryById(categoryId);
    }
}
