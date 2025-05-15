package com.hsy.preonboarding_backend31.api.product.controller;

import com.hsy.preonboarding_backend31.api.common.data.ApiResponse;
import com.hsy.preonboarding_backend31.api.product.dto.ProductDto;
import com.hsy.preonboarding_backend31.api.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productsService;

    @PostMapping
    public ApiResponse<ProductDto.RegistProductResponseDto> registProducts(@RequestBody final ProductDto.RegistProductRequestDto registProductDto) {
        ProductDto.RegistProductResponseDto response = productsService.registProduct(registProductDto);
        return ApiResponse.success("상품이 성공적으로 등록되었습니다.", response);
    }

}
