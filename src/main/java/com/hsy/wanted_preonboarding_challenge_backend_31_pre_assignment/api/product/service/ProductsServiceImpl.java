package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.product.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductsServiceImpl implements ProductsService {

    @Override
    @Transactional
    public String registProducts() {

        return "test";
    }

}
