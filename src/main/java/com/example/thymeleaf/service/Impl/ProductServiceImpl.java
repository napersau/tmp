package com.example.thymeleaf.service.Impl;

import com.example.thymeleaf.dto.request.ProductRequest;
import com.example.thymeleaf.dto.response.ProductResponse;
import com.example.thymeleaf.entity.Product;
import com.example.thymeleaf.repository.ProductRepository;
import com.example.thymeleaf.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDescription(product.getDescription());
        productResponse.setCategory(product.getCategory());
        productResponse.setQuantity(product.getQuantity());
        return productResponse;
    }

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .description(productRequest.getDescription())
                .quantity(productRequest.getQuantity())
                .build();
        Product savedProduct = productRepository.save(product);

    }

    @Override
    public void updateProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .description(productRequest.getDescription())
                .quantity(productRequest.getQuantity())
                .build();
        Product savedProduct = productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}
