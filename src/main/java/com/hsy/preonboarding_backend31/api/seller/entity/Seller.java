package com.hsy.preonboarding_backend31.api.seller.entity;

import com.hsy.preonboarding_backend31.api.common.entity.BaseCreatedTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "sellers")
public class Seller extends BaseCreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;
    private String logoUrl;

    private BigDecimal rating;
    private String contactEmail;
    private String contactPhone;

    @Builder
    public Seller(Long id, String name, String description, String logoUrl, BigDecimal rating, String contactEmail, String contactPhone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
        this.rating = rating;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }
}
