package com.hsy.preonboarding_backend31.api.product.controller;

import com.hsy.preonboarding_backend31.api.common.data.ApiResponse;
import com.hsy.preonboarding_backend31.api.product.dto.ProductDto;
import com.hsy.preonboarding_backend31.api.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productsService;

    @PostMapping
    public ApiResponse<ProductDto.ProductResponseDto> registProduct(@RequestBody final ProductDto.RegistProductRequestDto registProductDto) {
        ProductDto.ProductResponseDto response = productsService.registProduct(registProductDto);
        return ApiResponse.success("상품이 성공적으로 등록되었습니다.", response);
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductDto.ProductResponseDto> getProduct(@PathVariable final Long id) {
        ProductDto.ProductResponseDto response = productsService.getProductById(id);
        return ApiResponse.success("상품 상세 정보를 성공적으로 조회했습니다.", response);
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductDto.ProductResponseDto> modifyProduct(@PathVariable Long id, @RequestBody final ProductDto.ModifyProductRequestDto productDto) {
        ProductDto.ProductResponseDto response = productsService.modifyProduct(id, productDto);
        return ApiResponse.success("상품이 성공적으로 수정되었습니다..", response);
    }

}
