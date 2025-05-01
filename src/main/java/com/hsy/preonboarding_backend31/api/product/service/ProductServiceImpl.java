package com.hsy.preonboarding_backend31.api.product.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    @Transactional
    public String registProducts() {

        return "test";
    }

}
