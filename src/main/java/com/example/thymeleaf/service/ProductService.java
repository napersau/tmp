package com.example.thymeleaf.service;

import com.example.thymeleaf.dto.request.ProductRequest;
import com.example.thymeleaf.dto.response.ProductResponse;
import com.example.thymeleaf.entity.Product;

import java.util.List;

public interface ProductService {
    ProductResponse getProduct(Long id);
    void createProduct(ProductRequest productRequest);
    void updateProduct(ProductRequest productRequest);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
}
