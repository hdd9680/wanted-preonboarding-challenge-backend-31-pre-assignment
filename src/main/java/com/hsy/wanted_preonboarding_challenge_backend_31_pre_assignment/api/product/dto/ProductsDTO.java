package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductsDTO {

    private int id;
    private int sellerId;
    private int brandId;
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;

}
