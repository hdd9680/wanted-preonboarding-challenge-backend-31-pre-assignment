package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.products.repository;

import com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.products.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
}
