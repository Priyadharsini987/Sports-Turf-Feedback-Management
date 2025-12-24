package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;
import com.examly.springapp.repository.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private CategoryRepo categoryRepository;

    // CREATE
    @Override
    public Product addProduct(Product product) {
        // Optional: verify category exists
        if (product.getCategory() != null) {
            categoryRepository.findById(product.getCategory().getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
        }
        return productRepository.save(product);
    }

    // GET ALL
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET BY ID
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    // UPDATE
    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setPrice(product.getPrice());

            if (product.getCategory() != null) {
                existingProduct.setCategory(product.getCategory());
            }
            return productRepository.save(existingProduct);
        }).orElse(null);
    }
    @Override
public List<Product> getProductsByCategoryName(String categoryName) {
    return productRepository.findByCategory_CategoryName(categoryName);
}

@Override
public Product getProductByName(String productName) {
    return productRepository.findByProductName(productName);
}

}
