package com.examly.springapp.controller;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // CREATE PRODUCT
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.status(201).body(savedProduct);
    }

    // GET ALL PRODUCTS
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }
    // 1️⃣ Get products by category name
@GetMapping("/category/{categoryName}")
public ResponseEntity<List<Product>> getProductsByCategoryName(@PathVariable String categoryName) {
    List<Product> products = productService.getProductsByCategoryName(categoryName);
    if (products.isEmpty()) {
        return ResponseEntity.noContent().build(); // matches JUnit expectation
    }
    return ResponseEntity.ok(products);
}

@GetMapping("/name/{productName}")
public ResponseEntity<String> getProductByName(@PathVariable String productName) {
    Product product = productService.getProductByName(productName);
    if (product == null) {
        // Return exactly what the test expects
        return ResponseEntity.status(404)
                .body("No products found with name: " + productName);
    }
    return ResponseEntity.ok(product.getProductName()); // or wrap in list if needed
}



}
