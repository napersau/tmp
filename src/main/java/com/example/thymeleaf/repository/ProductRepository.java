package com.example.thymeleaf.repository;

import com.example.thymeleaf.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
