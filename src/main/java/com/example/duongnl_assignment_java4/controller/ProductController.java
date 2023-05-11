package com.example.duongnl_assignment_java4.controller;

import com.example.duongnl_assignment_java4.request.ProductRequest;
import com.example.duongnl_assignment_java4.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductRequest>> getAll() {
        return productService.findAll();
    }

    @GetMapping("/product/undeleted")
    public ResponseEntity<List<ProductRequest>> undeleted() {
        return productService.findByStatus(false);
    }

    @GetMapping("/product/deleted")
    public ResponseEntity<List<ProductRequest>> deleted() {
        return productService.findByStatus(true);
    }

//    @PreAuthorize("hasAnyRole('1','0')")
    @PostMapping("/add")
    public ResponseEntity<ProductRequest> post(@RequestBody @Valid ProductRequest productRequest) {
        return productService.save(productRequest);
    }

//    @PreAuthorize("hasAnyRole('1','0')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductRequest> put(@RequestBody @Valid ProductRequest productRequest) {
        return productService.update(productRequest);
    }

//    @PreAuthorize("hasAnyRole('1')")
    @PutMapping("/delete/{id}")
    public ResponseEntity<ProductRequest> delete(@RequestBody ProductRequest productRequest) {
        return productService.delete(productRequest);
    }

    @GetMapping("/product/detail/{id}")
    public ResponseEntity<ProductRequest> findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }


    @GetMapping("/product/findPrice/{min}/{max}")
    public ResponseEntity<List<ProductRequest>> findByPrice(@PathVariable("min") BigDecimal min, @PathVariable("max") BigDecimal max) {
        return productService.findByPrice(min, max);
    }
}
