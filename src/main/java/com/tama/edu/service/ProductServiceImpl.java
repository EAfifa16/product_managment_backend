package com.tama.edu.service;

import com.tama.edu.dao.ProductDao;
import com.tama.edu.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public ResponseEntity<Product> getProductById(String prdId) {
        System.out.println(" ================================== getProductById : "+prdId+ "=====================");
        Optional<Product> prdById = productDao.findById(prdId);
        if (prdById.isPresent()) {
            return new ResponseEntity<>(prdById.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(prdById.get(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Product> saveProduct(Product prd) {
        prd.setPrdId(UUID.randomUUID().toString());
        Product savedPrd = productDao.save(prd);
        return new ResponseEntity<>(savedPrd, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Product> updateProduct(String prdId, Product prd) {
        System.out.println(" ================================== updateProduct : "+prdId+ " : ==== : " + prd +" : =================");
        Optional<Product> prdById = productDao.findById(prdId);
        if (prdById.isPresent()) {
            Product product = prdById.get();
            product.setPrdName(prd.getPrdName());
            product.setPrdType(prd.getPrdType());
            return new ResponseEntity<>(productDao.save(product), HttpStatus.ACCEPTED);
        } else {
            prd.setPrdId(prdId);
            return new ResponseEntity<>(productDao.save(prd), HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<String> deleteProduct(String prdId) {
        System.out.println(" ================================== deleteProduct : "+prdId+ "=====================");
        Optional<Product> prdById = productDao.findById(prdId);
        if (prdById.isPresent()) {
            productDao.deleteById(prdId);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Record not Found", HttpStatus.NOT_FOUND);
        }
    }
}
