package com.hsy.preonboarding_backend31.api.seller.repository;

import com.hsy.preonboarding_backend31.api.seller.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
