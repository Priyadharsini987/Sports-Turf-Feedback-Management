package com.examly.springapp.service;

import com.examly.springapp.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category updateCategory(Long id, Category category);

    boolean deleteCategory(Long id);

    ResponseEntity<Page<Category>> getCategoriesByPage(int pageNumber, int pageSize);
}
