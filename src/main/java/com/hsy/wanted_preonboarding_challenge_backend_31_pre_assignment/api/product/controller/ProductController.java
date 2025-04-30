package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.product.controller;

import com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productsService;

    @GetMapping
    public String findProducts() {
        return "test";
    }

    @PostMapping
    public String registProducts() {
        productsService.registProducts();
        return "test";
    }

}
