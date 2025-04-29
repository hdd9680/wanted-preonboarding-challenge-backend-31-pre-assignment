package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="product_option_groups")
public class ProductOptionGroup {

    @Id
    private Long id;

    private String name;
    private Integer displayOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "optionGroup")
    private List<ProductOption> options;
}
