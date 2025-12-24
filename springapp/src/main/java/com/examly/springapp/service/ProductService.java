package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    List<Product> getProductsByCategoryName(String categoryName);
Product getProductByName(String productName);

}
