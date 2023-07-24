package com.tama.edu.controller;

import com.tama.edu.model.Product;
import com.tama.edu.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/findProduct/{prdId}")
    public ResponseEntity<Product> getProductById(@PathVariable String prdId) {
        return productService.getProductById(prdId);
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product prd) {
        return productService.saveProduct(prd);
    }

    @PutMapping("/updateProduct/{prdId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String prdId, @RequestBody Product prd) {
        return productService.updateProduct(prdId, prd);
    }

    @DeleteMapping("/deleteProduct/{prdId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String prdId) {
        return productService.deleteProduct(prdId);
    }

}
