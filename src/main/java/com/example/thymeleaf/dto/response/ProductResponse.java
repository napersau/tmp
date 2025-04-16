package com.example.thymeleaf.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String category;
    private double price;
    private int quantity;
}
