package com.hsy.preonboarding_backend31.api.review.entity;

import com.hsy.preonboarding_backend31.api.common.entity.BaseTimeEntity;
import com.hsy.preonboarding_backend31.api.product.entity.Product;
import com.hsy.preonboarding_backend31.api.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name="reviews")
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rating;
    private String title;
    private String content;
    private Boolean verifiedPurchase;
    private Integer helpfulVotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
