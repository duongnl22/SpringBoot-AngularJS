package com.example.duongnl_assignment_java4.service.Impl;

import com.example.duongnl_assignment_java4.entity.Product;
import com.example.duongnl_assignment_java4.exception.NotFoundException;
import com.example.duongnl_assignment_java4.repository.ProductRepository;
import com.example.duongnl_assignment_java4.request.ProductRequest;
import com.example.duongnl_assignment_java4.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseEntity<List<ProductRequest>> findAll() {
        List<Product> listProducts = productRepository.findAll();

        TypeToken<List<ProductRequest>> typeToken = new TypeToken<>() {
        };
        List<ProductRequest> listProductRespons = mapper.map(listProducts, typeToken.getType());


        return ResponseEntity.ok(listProductRespons);
    }

    @Override
    public ResponseEntity<List<ProductRequest>> findByStatus(Boolean bool) {
        List<Product> listProducts = productRepository.findAllProduct(bool);

        TypeToken<List<ProductRequest>> typeToken = new TypeToken<>() {
        };
        List<ProductRequest> listProductRespons = mapper.map(listProducts, typeToken.getType());

        return ResponseEntity.ok(listProductRespons);
    }

    @Override
    public ResponseEntity<List<ProductRequest>> findByPrice(BigDecimal min, BigDecimal max) {
        List<Product> listProducts = productRepository.findByPrice(min , max );

        TypeToken<List<ProductRequest>> typeToken = new TypeToken<>() {
        };
        List<ProductRequest> listProductRespons = mapper.map(listProducts, typeToken.getType());

        return ResponseEntity.ok(listProductRespons);
    }


    @Override
    public ResponseEntity<ProductRequest> findById(Long id) {
        if(!productRepository.existsById(id))
            throw new NotFoundException("Không tìm thấy đối tượng cần tìm !!");
        Optional<Product> product = productRepository.findById(id);

        ProductRequest productRequest = mapper.map(product.get(), ProductRequest.class);

        return ResponseEntity.ok(productRequest);
    }

    @Override
    public ResponseEntity<ProductRequest> save(ProductRequest productRequest) {
        Product product = mapper.map(productRequest, Product.class);

        product.setDeleted(false);
        product.setCreatedDate(LocalDateTime.now());

        Product productSave = productRepository.save(product);

        productRequest = mapper.map(productSave, ProductRequest.class);
        return ResponseEntity.ok(productRequest);
    }

    @Override
    public ResponseEntity<ProductRequest> update(ProductRequest productRequest) {
        Product product = mapper.map(productRequest, Product.class);

        product.setLastModifiedDate(LocalDateTime.now());

        Product productSave = productRepository.save(product);

        productRequest = mapper.map(productSave, ProductRequest.class);
        return ResponseEntity.ok(productRequest);

    }

    @Override
    public ResponseEntity<ProductRequest> delete(ProductRequest productRequest) {

        Product product = mapper.map(productRequest, Product.class);

        product.setDeleted(true);

        Product productSave = productRepository.save(product);

        productRequest = mapper.map(productSave, ProductRequest.class);
        return ResponseEntity.ok(productRequest);

    }
}
