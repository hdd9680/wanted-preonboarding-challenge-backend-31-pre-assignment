package com.hsy.preonboarding_backend31.api.product.repository;

import com.hsy.preonboarding_backend31.api.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
