package com.expenses.app.application.usecases.category;

import com.expenses.app.application.gateways.CategoryGateway;
import com.expenses.app.domain.entity.Category;

public class CreateCategoryInteractor {
    private final CategoryGateway categoryGateway;

    public CreateCategoryInteractor(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public Category execute(Category category) {
        return categoryGateway.createCategory(category);
    }
}
