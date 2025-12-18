package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;
@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public ResponseEntity<Product> postData(Product product) {
        if (product == null || product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Product saved = repo.save(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Product>> getData() {
        List<Product> list = repo.findAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

   
    public ResponseEntity<Product> getDataById(Long id) {
        Product existing = repo.findById(id).orElse(null);
        if (existing == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(existing, HttpStatus.OK);
    }

    public ResponseEntity<String> putData(Long id, Product updated) {
        Product existing = repo.findById(id).orElse(null);
        if (existing == null) return new ResponseEntity<>("No Record found", HttpStatus.NOT_FOUND);
        if (updated == null || updated.getProductName() == null || updated.getProductName().trim().isEmpty()) {
            return new ResponseEntity<>("Invalid data", HttpStatus.BAD_REQUEST);
        }

        existing.setProductName(updated.getProductName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setStockQuantity(updated.getStockQuantity());
        existing.setCategory(updated.getCategory());

        repo.save(existing);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteData(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new ResponseEntity<>("Record deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("No record found", HttpStatus.NOT_FOUND);
    }
}
