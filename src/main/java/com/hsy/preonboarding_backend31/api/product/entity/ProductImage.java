package com.hsy.preonboarding_backend31.api.product.entity;

import com.hsy.preonboarding_backend31.api.product.dto.ProductImageDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;
    private String altText;
    private Boolean isPrimary;
    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private ProductOption option;

    public static ProductImage of(ProductImageDto imageDto, Product product, ProductOption option) {
        return ProductImage.builder()
                .id(imageDto.getId())
                .url(imageDto.getUrl())
                .altText(imageDto.getAltText())
                .isPrimary(imageDto.getIsPrimary())
                .displayOrder(imageDto.getDisplayOrder())
                .product(product)
                .option(option)
                .build();
    }
}
