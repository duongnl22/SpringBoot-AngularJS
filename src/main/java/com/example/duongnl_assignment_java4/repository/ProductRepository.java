package com.example.duongnl_assignment_java4.repository;

import com.example.duongnl_assignment_java4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.id, p.name , p.size , p.color , p.price , p.quantity , p.description , p.created_user, p.created_date , p.last_modified_user , p.last_modified_date , p.deleted" +
            " FROM Product p WHERE p.deleted = :status", nativeQuery = true)
    List<Product> findAllProduct(@Param("status") Boolean bool);

    @Query(value = "SELECT p.id, p.name , p.size , p.color , p.price , p.quantity , p.description , p.created_user, p.created_date , p.last_modified_user , p.last_modified_date , p.deleted" +
            " FROM Product p WHERE p.price between ?1 and ?2", nativeQuery = true)
    List<Product> findByPrice(BigDecimal min, BigDecimal max);
}
