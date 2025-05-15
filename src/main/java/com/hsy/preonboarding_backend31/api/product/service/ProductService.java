package com.hsy.preonboarding_backend31.api.product.service;

import com.hsy.preonboarding_backend31.api.product.dto.ProductDto;

public interface ProductService {

    public ProductDto.RegistProductResponseDto registProduct(final ProductDto.RegistProductRequestDto registProductDto);

}
