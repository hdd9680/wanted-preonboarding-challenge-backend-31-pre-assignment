package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.seller.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String description;
    private String logoUrl;

    @Column(columnDefinition = "numeric(3,2)")
    private Double rating;
    private String contactEmail;
    private String contactPhone;

    @Column(updatable = false)
    private LocalDateTime createdAt;

}
