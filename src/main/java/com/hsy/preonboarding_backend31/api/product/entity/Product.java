package com.hsy.preonboarding_backend31.api.product.entity;

import com.hsy.preonboarding_backend31.api.brand.entity.Brand;
import com.hsy.preonboarding_backend31.api.categories.entity.Category;
import com.hsy.preonboarding_backend31.api.common.entity.BaseTimeEntity;
import com.hsy.preonboarding_backend31.api.product.dto.ProductDto;
import com.hsy.preonboarding_backend31.api.review.entity.Review;
import com.hsy.preonboarding_backend31.api.seller.entity.Seller;
import com.hsy.preonboarding_backend31.api.tags.entity.Tag;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="products")
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;
    private String shortDescription;
    private String fullDescription;

    @Column(nullable = false)
    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    @Setter
    private Seller seller;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    @Setter
    private Brand brand;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private ProductDetail detail;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private ProductPrice price;

    // Category를 ManyToMany 관계로 직접 참조
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Builder.Default
    private List<Category> categories = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ProductOptionGroup> optionGroups = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    public static Product from(ProductDto.RegistProductRequestDto registProductDto) {
        return Product.builder()
                .name(registProductDto.getName())
                .slug(registProductDto.getSlug())
                .shortDescription(registProductDto.getShortDescription())
                .fullDescription(registProductDto.getFullDescription())
                .seller(Seller.builder().id(registProductDto.getSellerId()).build())
                .brand(Brand.builder().id(registProductDto.getBrandId()).build())
                .status(registProductDto.getStatus())
                .build();
    }

    public static Product modifyProduct(ProductDto.ModifyProductRequestDto modifyDto, Product product) {
        if (modifyDto.getName() != null)
            product.name = modifyDto.getName();

        if (modifyDto.getSlug() != null)
            product.slug = modifyDto.getSlug();

        if (modifyDto.getShortDescription() != null)
            product.shortDescription = modifyDto.getShortDescription();

        if (modifyDto.getFullDescription() != null)
            product.fullDescription = modifyDto.getFullDescription();

        if (modifyDto.getStatus() != null)
            product.status = modifyDto.getStatus();

        return product;
    }
}
