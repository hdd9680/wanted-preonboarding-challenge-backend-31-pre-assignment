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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public ProductDto.RegistProductResponseDto registProduct(final ProductDto.RegistProductRequestDto registProductDto) {

        Product product = Product.of(registProductDto);

        Long sellerId = registProductDto.getSellerId();
        if(sellerId != null) {
            Seller seller = sellerRepository.findById(sellerId)
                    .orElseThrow(() -> ApiException.notFound("해당 판매자는 존재하지 않습니다."));
            product.setSeller(seller);
        }

        Long brandId = registProductDto.getBrandId();
        if(brandId != null) {
            Brand brand = brandRepository.findById(brandId)
                    .orElseThrow(() -> ApiException.notFound("해당 브랜드는 존재하지 않습니다."));
            product.setBrand(brand);
        }

        product = productRepository.save(product);

        ProductDetailDto productDetailDto = registProductDto.getDetail();
        if(productDetailDto != null) {
            ProductDetail productDetail = ProductDetail.of(productDetailDto, product);
            product.setDetail(productDetail);
        }

        ProductPriceDto productPriceDto = registProductDto.getPrice();
        if(productPriceDto != null) {
            ProductPrice productPrice = ProductPrice.of(productPriceDto, product);
            product.setPrice(productPrice);
        }


        if (registProductDto.getCategories() != null && !registProductDto.getCategories().isEmpty()) {
            List<Long> categoryIds = registProductDto.getCategories().stream()
                    .map(ProductCategoryDto::getCategoryId)
                    .toList();
            List<Category> categories = categoryRepository.findAllById(categoryIds);
            product.getCategories().addAll(categories);
        }

        if (registProductDto.getTags() != null && !registProductDto.getTags().isEmpty()) {
            List<Tag> tags = tagRepository.findAllById(registProductDto.getTags());
            product.getTags().addAll(tags);
        }

        if (registProductDto.getOptionGroups() != null && !registProductDto.getOptionGroups().isEmpty()) {
            for (ProductOptionGroupDto optionGroupDto : registProductDto.getOptionGroups()) {
                ProductOptionGroup group = ProductOptionGroup.of(optionGroupDto, product);
                product.getOptionGroups().add(group);

                if(optionGroupDto.getOptions() == null || optionGroupDto.getOptions().isEmpty()) break;

                for (ProductOptionDto optionDto : optionGroupDto.getOptions()) {
                    ProductOption option = ProductOption.of(optionDto, group);
                    group.getOptions().add(option);
                }
            }
        }

        if (registProductDto.getImages() != null && !registProductDto.getImages().isEmpty()) {
            for (ProductImageDto imageDto : registProductDto.getImages()) {
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
        return ProductDto.RegistProductResponseDto.of(product);
    }

}
