package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@NoArgsConstructor
//@Table(name = "product_details")
public class ProductDetailsEntity {

    @Id
    private Long id;
    private Long productId;
    private Double weight;
    private String dimensions;
    private String materials;
    private String additionalInfo;
    private String countryOfOrigin;
    private String warrantyInfo;
    private String careInstructions;


}
