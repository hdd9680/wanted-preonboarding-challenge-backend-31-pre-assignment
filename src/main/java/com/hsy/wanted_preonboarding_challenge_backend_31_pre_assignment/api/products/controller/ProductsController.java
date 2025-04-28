package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @GetMapping
    public String findProducts() {
        return "test";
    }

}
