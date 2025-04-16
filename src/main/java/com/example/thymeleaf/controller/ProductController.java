package com.example.thymeleaf.controller;


import com.example.thymeleaf.dto.request.ProductRequest;
import com.example.thymeleaf.dto.response.ProductResponse;
import com.example.thymeleaf.entity.Product;
import com.example.thymeleaf.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        ProductResponse product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute ProductRequest productRequest) {
        productService.updateProduct(productRequest);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/add")
    public String addProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/add")
    public String createProductPage(@ModelAttribute ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return "redirect:/product";
    }
}

