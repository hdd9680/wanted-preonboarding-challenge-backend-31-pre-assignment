package com.hsy.preonboarding_backend31.api.product.entity;

import com.hsy.preonboarding_backend31.api.product.dto.ProductDetailDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal weight;
    private String materials;
    private String countryOfOrigin;
    private String warrantyInfo;
    private String careInstructions;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> dimensions;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> additionalInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public static ProductDetail of(ProductDetailDto detail, Product product) {
        return detail == null ? null :
                ProductDetail.builder()
                .id(detail.getId())
                .weight(detail.getWeight())
                .materials(detail.getMaterials())
                .countryOfOrigin(detail.getCountryOfOrigin())
                .warrantyInfo(detail.getWarrantyInfo())
                .careInstructions(detail.getCareInstructions())
                .dimensions(detail.getDimensions())
                .additionalInfo(detail.getAdditionalInfo())
                .product(product)
                .build();
    }

    public static ProductDetail modifyProductDetail(ProductDetailDto productDetailDto, ProductDetail productDetail) {
        if (productDetailDto.getWeight() != null)
            productDetail.weight = productDetailDto.getWeight();

        if (productDetailDto.getDimensions() != null)
            productDetail.dimensions = productDetailDto.getDimensions();

        if (productDetailDto.getMaterials() != null)
            productDetail.materials = productDetailDto.getMaterials();

        if (productDetailDto.getCountryOfOrigin() != null)
            productDetail.countryOfOrigin = productDetailDto.getCountryOfOrigin();

        if (productDetailDto.getWarrantyInfo() != null)
            productDetail.warrantyInfo = productDetailDto.getWarrantyInfo();

        if (productDetailDto.getCareInstructions() != null)
            productDetail.careInstructions = productDetailDto.getCareInstructions();

        if (productDetailDto.getAdditionalInfo() != null)
            productDetail.additionalInfo = productDetailDto.getAdditionalInfo();

        return productDetail;
    }
}
