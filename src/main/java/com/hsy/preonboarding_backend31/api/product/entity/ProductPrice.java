package com.hsy.preonboarding_backend31.api.product.entity;

import com.hsy.preonboarding_backend31.api.product.dto.ProductPriceDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_prices")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal basePrice;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private String currency;
    private BigDecimal taxRate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public static ProductPrice of(ProductPriceDto price, Product product) {
        return price == null ? null :
                ProductPrice.builder()
                .basePrice(price.getBasePrice())
                .salePrice(price.getSalePrice())
                .costPrice(price.getCostPrice())
                .currency(price.getCurrency())
                .taxRate(price.getTaxRate())
                .product(product)
                .build();
    }

    public static ProductPrice modifyProductPrice(ProductPriceDto priceDto, ProductPrice price) {
        if (priceDto.getBasePrice() != null)
            price.basePrice = priceDto.getBasePrice();

        if (priceDto.getSalePrice() != null)
            price.salePrice = priceDto.getSalePrice();

        if (priceDto.getCurrency() != null)
            price.currency = priceDto.getCurrency();

        if (priceDto.getTaxRate() != null)
            price.taxRate = priceDto.getTaxRate();

        return price;
    }
}
