package com.examly.springapp.service;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return categoryRepository.findById(id).map(existing -> {
            existing.setCategoryName(category.getCategoryName());
            return categoryRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public boolean deleteCategory(Long id) {
        return categoryRepository.findById(id).map(existing -> {
            categoryRepository.delete(existing);
            return true;
        }).orElse(false);
    }

   
    @Override
    public ResponseEntity<Page<Category>> getCategoriesByPage(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(
                pageNumber,
                pageSize,
                Sort.by("categoryId").ascending()   // REQUIRED FOR TEST
        );

        Page<Category> page = categoryRepository.findAll(pageable);

        
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}
