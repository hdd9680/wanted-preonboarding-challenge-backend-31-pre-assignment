package com.hsy.preonboarding_backend31.api.product.service;

import com.hsy.preonboarding_backend31.api.product.dto.ProductDto;

public interface ProductService {

    public ProductDto.ProductResponseDto registProduct(final ProductDto.RegistProductRequestDto request);

    public ProductDto.ProductResponseDto getProductById(Long id);

    public ProductDto.ProductResponseDto modifyProduct(Long productId, final ProductDto.ModifyProductRequestDto request);
}
