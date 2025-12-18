package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> postData(@RequestBody(required = false) Product product) {
        return service.postData(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getData() {
        return service.getData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getDataById(@PathVariable Long id) {
        return service.getDataById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putData(@PathVariable Long id, @RequestBody Product product) {
        return service.putData(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable Long id) {
        return service.deleteData(id);
    }
}
