package com.example.duongnl_assignment_java4.service;

import com.example.duongnl_assignment_java4.entity.Product;
import com.example.duongnl_assignment_java4.request.ProductRequest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ResponseEntity<List<ProductRequest>> findAll();

    ResponseEntity<List<ProductRequest>> findByStatus(Boolean bool);

    ResponseEntity<List<ProductRequest>> findByPrice(BigDecimal min , BigDecimal max);

    ResponseEntity<ProductRequest> findById(Long id);

    ResponseEntity<ProductRequest> save(ProductRequest productRequest);

    ResponseEntity<ProductRequest> update(ProductRequest productRequest);

    ResponseEntity<ProductRequest> delete(ProductRequest productRequest);


}
