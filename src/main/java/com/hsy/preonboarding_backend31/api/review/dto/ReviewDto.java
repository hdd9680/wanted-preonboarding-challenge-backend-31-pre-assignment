package com.hsy.preonboarding_backend31.api.review.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseTimeDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ReviewDto extends BaseTimeDto {

    private Long id;
    private Long productId;
    private Long userId;
    private Integer rating;
    private String title;
    private String content;
    private Boolean verifiedPurchase;
    private Integer helpfulVotes;

}
