package com.hsy.preonboarding_backend31.api.seller.entity;

import com.hsy.preonboarding_backend31.api.common.entity.BaseCreatedTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

}
