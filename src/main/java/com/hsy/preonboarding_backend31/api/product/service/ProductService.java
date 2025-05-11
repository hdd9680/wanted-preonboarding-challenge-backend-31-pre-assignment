package com.hsy.preonboarding_backend31.api.product.service;

import com.hsy.preonboarding_backend31.api.product.dto.ProductDTO;

public interface ProductService {

    public ProductDTO.RegistProductResponseDto registProduct(final ProductDTO.RegistProductRequestDto registProductDto);

}
