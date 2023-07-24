package com.tama.edu.service;

import com.tama.edu.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();

    public ResponseEntity<Product> getProductById(String prdId);

    public ResponseEntity<Product> saveProduct(Product prd);

    public ResponseEntity<Product> updateProduct(String prdId, Product prd);

    public ResponseEntity<String> deleteProduct(String prdId);
}
