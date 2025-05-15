package com.hsy.preonboarding_backend31.api.product.entity;

import com.hsy.preonboarding_backend31.api.product.dto.ProductOptionGroupDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_option_groups")
public class ProductOptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "optionGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ProductOption> options = new ArrayList<>();

    public static ProductOptionGroup of(ProductOptionGroupDto groupDto, Product product) {
        return ProductOptionGroup.builder()
                .id(groupDto.getId())
                .name(groupDto.getName())
                .displayOrder(groupDto.getDisplayOrder())
                .product(product)
                .build();
    }
}
