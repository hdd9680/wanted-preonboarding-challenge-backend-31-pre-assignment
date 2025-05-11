package com.hsy.preonboarding_backend31.api.product.service;

import com.hsy.preonboarding_backend31.api.brand.entity.Brand;
import com.hsy.preonboarding_backend31.api.product.dto.ProductDTO;
import com.hsy.preonboarding_backend31.api.product.entity.Product;
import com.hsy.preonboarding_backend31.api.product.repository.ProductRepository;
import com.hsy.preonboarding_backend31.api.seller.entity.Seller;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public ProductDTO.RegistProductResponseDto registProduct(final ProductDTO.RegistProductRequestDto registProductDto) {

        Product newProduct = Product.builder()
                .name(registProductDto.getName())
                .slug(registProductDto.getSlug())
                .shortDescription(registProductDto.getShortDescription())
                .fullDescription(registProductDto.getFullDescription())
                .seller(Seller.builder().id(registProductDto.getSellerId()).build())
                .brand(Brand.builder().id(registProductDto.getBrandId()).build())
                .status(registProductDto.getStatus())
                .build();
        productRepository.save(newProduct);

        return ProductDTO.RegistProductResponseDto.builder()
                .id(newProduct.getId())
                .name(newProduct.getName())
                .slug(newProduct.getSlug())
                .createdAt(newProduct.getCreatedAt())
                .updatedAt(newProduct.getUpdatedAt())
                .build();
    }

}
