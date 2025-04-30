package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.product.entity;

import com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.tags.entity.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="product_tags")
public class ProductTag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

}
