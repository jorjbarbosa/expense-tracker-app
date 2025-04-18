package com.expenses.app.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.expenses.app.application.gateways.CategoryGateway;
import com.expenses.app.application.usecases.category.CreateCategoryInteractor;
import com.expenses.app.application.usecases.category.GetCategoryInteractor;
import com.expenses.app.application.usecases.category.UpdateCategoryInteractor;
import com.expenses.app.infrastructure.gateways.CategoryGatewayImpl;
import com.expenses.app.infrastructure.mappers.CategoryMapper;
import com.expenses.app.infrastructure.persistence.repository.CategoryRepository;

@Configuration
public class CategoryConfig {
    @Bean
    CategoryGateway categoryGateway(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        return new CategoryGatewayImpl(categoryRepository, categoryMapper);
    }

    @Bean
    CreateCategoryInteractor createCategoryUseCase(CategoryGateway categoryGateway) {
        return new CreateCategoryInteractor(categoryGateway);
    }

    @Bean
    GetCategoryInteractor getCategoryUseCase(CategoryGateway categoryGateway) {
        return new GetCategoryInteractor(categoryGateway);
    }

    @Bean
    UpdateCategoryInteractor updateCategoryUseCase(CategoryGateway categoryGateway) {
        return new UpdateCategoryInteractor(categoryGateway);
    }
}
