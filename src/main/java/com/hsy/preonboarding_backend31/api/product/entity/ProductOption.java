package com.hsy.preonboarding_backend31.api.product.entity;

import com.hsy.preonboarding_backend31.api.product.dto.ProductOptionDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_options")
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private BigDecimal additionalPrice;
    private String sku;
    private Integer stock;
    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_group_id")
    private ProductOptionGroup optionGroup;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImages;

    public static ProductOption of(ProductOptionDto optionDto, ProductOptionGroup group) {
        return ProductOption.builder()
                .id(optionDto.getId())
                .name(optionDto.getName())
                .additionalPrice(optionDto.getAdditionalPrice())
                .sku(optionDto.getSku())
                .stock(optionDto.getStock())
                .displayOrder(optionDto.getDisplayOrder())
                .optionGroup(group)
                .build();
    }
}
