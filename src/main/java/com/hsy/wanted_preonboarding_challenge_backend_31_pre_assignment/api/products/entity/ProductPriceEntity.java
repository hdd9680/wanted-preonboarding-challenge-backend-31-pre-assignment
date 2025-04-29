package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//@Entity
//@Table(name="product_prices")
public class ProductPriceEntity {

    @Id
    private Long id;

    private Long productId;
    private Double basePrice;
    private Double salePrice;
    private Double costPrice;
    private String currency;
    private Double taxRate;

}
