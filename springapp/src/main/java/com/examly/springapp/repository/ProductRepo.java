package com.examly.springapp.repository;

import com.examly.springapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // Find product by exact name
    Product findByProductName(String productName);

    // Find all products by category name
    List<Product> findByCategory_CategoryName(String categoryName);
}
