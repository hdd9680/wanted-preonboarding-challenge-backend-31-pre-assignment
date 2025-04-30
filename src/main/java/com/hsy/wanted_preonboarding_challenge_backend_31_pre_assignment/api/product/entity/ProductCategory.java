package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.product.entity;

import com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.categories.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Boolean isPrimary;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
