package com.expenses.app.presentation.rest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.app.application.usecases.category.CreateCategoryInteractor;
import com.expenses.app.application.usecases.category.GetCategoryInteractor;
import com.expenses.app.domain.entity.Category;
import com.expenses.app.infrastructure.mappers.CategoryMapper;
import com.expenses.app.presentation.rest.dto.CategoryRequestDTO;
import com.expenses.app.presentation.rest.dto.CategoryResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CreateCategoryInteractor createCategoryUseCase;
    private final GetCategoryInteractor getCategoryUseCase;
    private final CategoryMapper categoryMapper;

    public CategoryController(CreateCategoryInteractor createCategoryUseCase, GetCategoryInteractor getCategoryUseCase, CategoryMapper categoryMapper) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.getCategoryUseCase = getCategoryUseCase;
        this.categoryMapper = categoryMapper;
    }
    @PostMapping  
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO requset) {
        Category category = categoryMapper.mapToCategory(requset);
        Category createdCategory = createCategoryUseCase.execute(category);
        return ResponseEntity.ok(categoryMapper.mapToCategoryResponseDTO(createdCategory));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDTO> getCategory(@PathVariable UUID id) {
        Category category = getCategoryUseCase.execute(id);
        return ResponseEntity.ok(categoryMapper.mapToCategoryResponseDTO(category));
    }
    
}
