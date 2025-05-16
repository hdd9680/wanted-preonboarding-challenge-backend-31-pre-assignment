package com.hsy.preonboarding_backend31.api.product.service;

import com.hsy.preonboarding_backend31.api.brand.entity.Brand;
import com.hsy.preonboarding_backend31.api.brand.repository.BrandRepository;
import com.hsy.preonboarding_backend31.api.categories.entity.Category;
import com.hsy.preonboarding_backend31.api.categories.repository.CategoryRepository;
import com.hsy.preonboarding_backend31.api.common.data.ApiException;
import com.hsy.preonboarding_backend31.api.product.dto.*;
import com.hsy.preonboarding_backend31.api.product.entity.*;
import com.hsy.preonboarding_backend31.api.product.repository.ProductRepository;
import com.hsy.preonboarding_backend31.api.product.repository.repository.ProductOptionRepository;
import com.hsy.preonboarding_backend31.api.seller.entity.Seller;
import com.hsy.preonboarding_backend31.api.seller.repository.SellerRepository;
import com.hsy.preonboarding_backend31.api.tags.entity.Tag;
import com.hsy.preonboarding_backend31.api.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final ProductOptionRepository productOptionRepository;

    @Override
    @Transactional
    public ProductDto.ProductResponseDto registProduct(final ProductDto.RegistProductRequestDto request) {

        Product product = Product.of(request);

        Long sellerId = request.getSellerId();
        if(sellerId != null) {
            Seller seller = sellerRepository.findById(sellerId)
                    .orElseThrow(() -> ApiException.notFound("해당 판매자는 존재하지 않습니다."));
            product.setSeller(seller);
        }

        Long brandId = request.getBrandId();
        if(brandId != null) {
            Brand brand = brandRepository.findById(brandId)
                    .orElseThrow(() -> ApiException.notFound("해당 브랜드는 존재하지 않습니다."));
            product.setBrand(brand);
        }

        product = productRepository.save(product);

        ProductDetailDto productDetailDto = request.getDetail();
        if(productDetailDto != null) {
            ProductDetail productDetail = ProductDetail.of(productDetailDto, product);
            product.setDetail(productDetail);
        }

        ProductPriceDto productPriceDto = request.getPrice();
        if(productPriceDto != null) {
            ProductPrice productPrice = ProductPrice.of(productPriceDto, product);
            product.setPrice(productPrice);
        }


        if (request.getCategories() != null && !request.getCategories().isEmpty()) {
            List<Long> categoryIds = request.getCategories().stream()
                    .map(ProductCategoryDto::getCategoryId)
                    .toList();
            List<Category> categories = categoryRepository.findAllById(categoryIds);
            product.getCategories().addAll(categories);
        }

        if (request.getTags() != null && !request.getTags().isEmpty()) {
            List<Tag> tags = tagRepository.findAllById(request.getTags());
            product.getTags().addAll(tags);
        }

        if (request.getOptionGroups() != null && !request.getOptionGroups().isEmpty()) {
            for (ProductOptionGroupDto optionGroupDto : request.getOptionGroups()) {
                ProductOptionGroup group = ProductOptionGroup.of(optionGroupDto, product);
                product.getOptionGroups().add(group);

                if(optionGroupDto.getOptions() == null || optionGroupDto.getOptions().isEmpty()) break;

                for (ProductOptionDto optionDto : optionGroupDto.getOptions()) {
                    ProductOption option = ProductOption.of(optionDto, group);
                    group.getOptions().add(option);
                }
            }
        }

        if (request.getImages() != null && !request.getImages().isEmpty()) {
            for (ProductImageDto imageDto : request.getImages()) {
                ProductOption option = null;
                if (imageDto.getOptionId() != null) {
                    option = productOptionRepository.findById(imageDto.getOptionId())
                            .orElse(null);
                }
                ProductImage image = ProductImage.of(imageDto, product, option);
                product.getImages().add(image);
            }
        }

        productRepository.save(product);
        return ProductDto.ProductResponseDto.of(product);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto.ProductResponseDto getProductById(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> ApiException.notFound("존재하지 않는 상품입니다."));

        return ProductDto.ProductResponseDto.of(product);
    }

    @Override
    @Transactional
    public ProductDto.ProductResponseDto modifyProduct(Long productId, final ProductDto.ModifyProductRequestDto request) {

        Product product = productRepository.findById(productId)
                .map(entity -> Product.modifyProduct(request, entity))
                .orElseThrow(() -> ApiException.notFound("해당 상품은 존재하지 않습니다."));

        Long sellerId = request.getSellerId();
        if (sellerId != null) {
            Seller seller = sellerRepository.findById(sellerId)
                    .orElseThrow(() -> ApiException.notFound("해당 판매자는 존재하지 않습니다."));
            product.setSeller(seller);
        }

        Long brandId = request.getBrandId();
        if (brandId != null) {
            Brand brand = brandRepository.findById(brandId)
                    .orElseThrow(() -> ApiException.notFound("해당 브랜드는 존재하지 않습니다."));
            product.setBrand(brand);
        }

        ProductDetailDto productDetailDto = request.getDetail();
        ProductDetail productDetail = product.getDetail();
        if (productDetailDto != null && productDetail != null) {
            ProductDetail.modifyProductDetail(productDetailDto, productDetail);
        }

        ProductPriceDto productPriceDto = request.getPrice();
        ProductPrice productPrice = product.getPrice();
        if (productPriceDto != null && productPrice != null) {
            ProductPrice.modifyProductPrice(productPriceDto, productPrice);
        }

        if (request.getCategories() != null) {
            product.getCategories().clear();
            List<Long> categoryIds = request.getCategories().stream()
                    .map(ProductCategoryDto::getCategoryId)
                    .toList();
            List<Category> categories = categoryRepository.findAllById(categoryIds);
            product.getCategories().addAll(categories);
        }

        if (request.getTagIds() != null) {
            product.getTags().clear();
            List<Tag> tags = tagRepository.findAllById(request.getTagIds());
            product.getTags().addAll(tags);
        }

        product = productRepository.save(product);


        return ProductDto.ProductResponseDto.of(null);
    }

}
