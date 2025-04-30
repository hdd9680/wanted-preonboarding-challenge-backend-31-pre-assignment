package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="product_prices")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double basePrice;
    private Double salePrice;
    private Double costPrice;
    private String currency;
    private Double taxRate;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
