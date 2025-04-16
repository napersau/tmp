package com.example.thymeleaf.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long id;
    private String name;
    private String description;
    private String category;
    private double price;
    private int quantity;
}
